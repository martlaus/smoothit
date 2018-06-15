package it.smooth.components.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
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
  private String brand;

  @NotNull
  private Long kcalPerUnit;

  @NotNull
  private String unit;

  @NotNull
  private Long unitPriceEur;

  @NotNull
  private String colorHex;

  @Lob
  private byte[] file;

  private Long amount;
}
