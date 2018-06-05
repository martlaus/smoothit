package it.smooth.smoothie.controller;

import it.smooth.smoothie.model.Smoothie;
import it.smooth.smoothie.service.SmoothieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping
  @CrossOrigin
  public Smoothie create(
    @RequestBody Smoothie smoothie) {
    return smoothieService.create(smoothie);
  }

}
