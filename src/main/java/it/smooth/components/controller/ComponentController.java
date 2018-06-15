package it.smooth.components.controller;

import it.smooth.components.model.Component;
import it.smooth.components.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/components", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

  @PostMapping(value = "/{id}/file")
  @CrossOrigin
  public Component addFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
    Optional<Component> componentOp = componentService.findById(id);
    if (componentOp.isPresent()) {
      try {
        Component component = componentOp.get();
        component.setFile(file.getBytes());
        return componentService.create(component);
      }
      catch (IOException ignored) {
        System.out.println(ignored.getMessage());
      }
    }
    return null;
  }

  @DeleteMapping
  @CrossOrigin
  public void delete(
    @RequestBody Component component) {
    componentService.delete(component);
  }

}
