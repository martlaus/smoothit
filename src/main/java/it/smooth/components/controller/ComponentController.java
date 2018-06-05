package it.smooth.components.controller;

import it.smooth.components.model.Component;
import it.smooth.components.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/components")
@RequiredArgsConstructor
public class ComponentController {

  private final ComponentService componentService;

  @GetMapping("/search")
  @CrossOrigin
  public Iterable<Component> search(
    @RequestParam String term,
    @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
    return componentService.search(pageable, term);
  }

  @GetMapping
  @CrossOrigin
  public Iterable<Component> findAll(
    @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
    return componentService.findAll(pageable);
  }

  @PostMapping
  @CrossOrigin
  public Component create(
    @RequestBody Component component) {
    return componentService.create(component);
  }

  @DeleteMapping
  @CrossOrigin
  public void delete(
    @RequestBody Component component) {
    componentService.delete(component);
  }

}
