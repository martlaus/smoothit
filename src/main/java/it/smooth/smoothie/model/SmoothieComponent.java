package it.smooth.smoothie.model;

import it.smooth.components.model.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SmoothieComponent implements Serializable {

  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  @JoinColumn(name = "smoothie_id", referencedColumnName = "id")
  private Smoothie smoothie;
  @ManyToOne
  @JoinColumn(name = "component_id", referencedColumnName = "id")
  private Component component;
  private Long amount;

  public SmoothieComponent() {
    // For serialization
  }

  private SmoothieComponent(Builder builder) {
    smoothie = builder.smoothie;
    setComponent(builder.component);
    setAmount(builder.amount);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Component getComponent() {
    return component;
  }

  public void setComponent(Component component) {
    this.component = component;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }


  public static final class Builder {
    private Smoothie smoothie;
    private Component component;
    private Long amount;

    private Builder() {
    }

    public Builder smoothie(Smoothie smoothie) {
      this.smoothie = smoothie;
      return this;
    }

    public Builder component(Component component) {
      this.component = component;
      return this;
    }

    public Builder amount(Long amount) {
      this.amount = amount;
      return this;
    }

    public SmoothieComponent build() {
      return new SmoothieComponent(this);
    }
  }
}
