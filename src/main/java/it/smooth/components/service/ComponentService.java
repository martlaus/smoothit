package it.smooth.components.service;

import it.smooth.components.model.Component;
import it.smooth.components.repository.ComponentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ComponentService {

  private ComponentRepository componentRepository;

  public Page<Component> findAll(Pageable pageable) {
    return componentRepository.findAll(pageable);
  }


  public Iterable<Component> search(Pageable pageable, String term) {
    return componentRepository.findByNameContains(term, pageable);
  }

  public Component create(Component component) {
    return componentRepository.save(component);
  }

  public void delete(Component component) {
    componentRepository.delete(component);
  }
}
