package it.smooth.smoothie.service;

import it.smooth.smoothie.model.Smoothie;
import it.smooth.smoothie.repository.SmoothieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SmoothieService {

  private SmoothieRepository smoothieRepository;

  public Page<Smoothie> findAll(Pageable pageable) {
    return smoothieRepository.findAll(pageable);
  }


}
