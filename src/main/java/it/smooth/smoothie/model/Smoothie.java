package it.smooth.smoothie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import it.smooth.components.model.Component;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
public class Smoothie implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String name;

  private String description;

  private Long calories;

  private String instructions;

  @Lob
  private byte[] file;


  @ApiModelProperty(hidden = true)
  @JsonIgnore
  @OneToMany(mappedBy = "smoothie", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<SmoothieComponent> smoothieComponents;

  @Transient
  private Set<Component> components;

  public Set<Component> getComponents() {
    if (smoothieComponents != null && !smoothieComponents.isEmpty()) {
      return smoothieComponents.stream().map(smoothieComponent -> {
        Component component = smoothieComponent.getComponent();
        component.setAmount(smoothieComponent.getAmount());
        return component;
      }).collect(Collectors.toSet());
    } else {
      return components;
    }
  }

  public Long getCalories() {
    return getComponents().stream()
            .map(c -> c.getKcalPerUnit() * Optional.ofNullable(c.getAmount()).orElse(0L))
            .mapToLong(Long::longValue).sum();
  }
}
