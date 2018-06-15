package it.smooth.smoothie.model;

import it.smooth.components.model.Component;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Smoothie {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private String description;

  @NotNull
  private Long calories;

  @NotNull
  private String instructions;

  @Lob
  private byte[] file;

  @ManyToMany
  @JoinTable(
    name = "smoothie_components",
    joinColumns = @JoinColumn(name = "smoothie_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "component_id", referencedColumnName = "id"))
  private List<Component> smoothieComponents;
}
