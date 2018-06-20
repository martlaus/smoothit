package it.smooth.smoothie.service;

import it.smooth.components.model.Component;
import it.smooth.components.service.ComponentService;
import it.smooth.smoothie.model.Smoothie;
import it.smooth.smoothie.model.SmoothieComponent;
import it.smooth.smoothie.repository.SmoothieComponentRepository;
import it.smooth.smoothie.repository.SmoothieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class SmoothieService {

  private SmoothieRepository smoothieRepository;
  private SmoothieComponentRepository smoothieComponentRepository;
  private ComponentService componentService;

  public Optional<Smoothie> findById(Long id) {
    return smoothieRepository.findById(id);
  }

  public Page<Smoothie> findAll(Pageable pageable) {
    return smoothieRepository.findAll(pageable);
  }


  public Smoothie create(Smoothie smoothie) {
    if (smoothie != null && smoothie.getId() != null) {
      Smoothie smoothie1 = smoothieRepository.findById(smoothie.getId()).get();
      if (smoothie1.getSmoothieComponents() != null && !smoothie1.getSmoothieComponents().isEmpty()) {
        smoothieComponentRepository.deleteAll(smoothie1.getSmoothieComponents());
      }
      smoothieRepository.deleteById(smoothie1.getId());
      smoothie.setId(null);
    }

    Long calories = smoothie.getComponents().stream()
      .map(component -> {
        Component dbComponent;
        if (component.getId() == null) {
          dbComponent = componentService.create(component);
        }
        else {
          dbComponent = componentService.findById(component.getId()).get();
        }

        return dbComponent.getKcalPerUnit() * component.getAmount();
      })
      .mapToLong(Long::longValue).sum();

    Set<SmoothieComponent> smoothieComponents = smoothie.getComponents().stream()
      .map(component -> {
          Component dbComponent = componentService.findById(component.getId()).get();

          return SmoothieComponent.newBuilder()
            .component(dbComponent)
            .smoothie(smoothie)
            .amount(component.getAmount())
            .build();
        }
      ).collect(Collectors.toSet());

    smoothie.setCalories(calories);
    smoothie.setSmoothieComponents(smoothieComponents);

    return smoothieRepository.save(smoothie);
  }

  public void delete(Long id) {
    smoothieRepository.deleteById(id);
  }
}
