package it.smooth.components.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Component {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private Long price;

  @NotNull
  private String description;

  @NotNull
  private Long calories;

  @NotNull
  private Long weight;
}
