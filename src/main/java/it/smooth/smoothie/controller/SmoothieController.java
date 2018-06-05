package it.smooth.smoothie.controller;

import it.smooth.smoothie.model.Smoothie;
import it.smooth.smoothie.service.SmoothieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smoothies")
@RequiredArgsConstructor
public class SmoothieController {

  private final SmoothieService smoothieService;

  @GetMapping
  @CrossOrigin
  public Iterable<Smoothie> findAll(
    @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
    return smoothieService.findAll(pageable);
  }

}
