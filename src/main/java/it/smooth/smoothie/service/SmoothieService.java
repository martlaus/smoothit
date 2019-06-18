package it.smooth.smoothie.service;

import it.smooth.components.service.ComponentService;
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
  private ComponentService componentService;

  public Optional<Smoothie> findById(Long id) {
    return smoothieRepository.findById(id);
  }

  public Page<Smoothie> findAll(Pageable pageable) {
    return smoothieRepository.findAll(pageable);
  }

  public Smoothie create(Smoothie smoothie) {
    return smoothieRepository.save(smoothie);
  }

  public void delete(Long id) {
    smoothieRepository.deleteById(id);
  }

  public Optional<Smoothie> getOne(Long id) {
    return smoothieRepository.findById(id);
  }
}
