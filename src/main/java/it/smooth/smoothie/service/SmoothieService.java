package it.smooth.smoothie.service;

import it.smooth.smoothie.model.Smoothie;
import it.smooth.smoothie.repository.SmoothieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class SmoothieService {

  private SmoothieRepository smoothieRepository;

  public Optional<Smoothie> findById(Long id) {
    return smoothieRepository.findById(id);
  }

  public Page<Smoothie> findAll(Pageable pageable) {
    return smoothieRepository.findAll(pageable);
  }


  public Smoothie create(Smoothie smoothie) {
    Long calories = smoothie.getSmoothieComponents().stream()
      .map(component -> component.getKcalPerUnit() * component.getAmount())
      .mapToLong(Long::longValue).sum();

    smoothie.setCalories(calories);

    return smoothieRepository.save(smoothie);
  }
}
