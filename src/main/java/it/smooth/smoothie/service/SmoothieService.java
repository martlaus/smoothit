package it.smooth.smoothie.service;

import it.smooth.components.model.Component;
import it.smooth.components.service.ComponentService;
import it.smooth.smoothie.model.Smoothie;
import it.smooth.smoothie.model.SmoothieComponent;
import it.smooth.smoothie.repository.SmoothieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Slf4j
@Service
@AllArgsConstructor
public class SmoothieService {
  private SmoothieRepository smoothieRepository;
  private ComponentService componentService;

  public Optional<Smoothie> findById(Long id) {
    return smoothieRepository.findById(id);
  }

  public Page<Smoothie> findAll(Pageable pageable) {
    return smoothieRepository.findAll(pageable);
  }

  public Smoothie create(Smoothie smoothie) {
    Set<SmoothieComponent> smoothieComponents = getSmoothieComponents(smoothie);

    smoothie.setSmoothieComponents(smoothieComponents);

    return smoothieRepository.save(smoothie);
  }

  private Set<SmoothieComponent> getSmoothieComponents(Smoothie smoothie) {
    return smoothie.getComponents().stream()
            .map(component -> {
                      Optional<Component> byId = componentService.findById(component.getId());
                      Component dbComponent = null;
                      if (byId.isPresent()) {
                        dbComponent = byId.get();
                      }

                      return SmoothieComponent.newBuilder()
                              .component(dbComponent != null ? dbComponent : component)
                              .smoothie(smoothie)
                              .amount(Optional.ofNullable(component.getAmount()).orElse(0L))
                              .build();
                    }
            ).collect(toSet());
  }

  public void delete(Long id) {
    smoothieRepository.deleteById(id);
  }
}
