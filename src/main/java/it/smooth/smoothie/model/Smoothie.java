package it.smooth.smoothie.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "smoothie_id", referencedColumnName = "id")
    private Set<SmoothieComponent> smoothieComponents;

    public Long getCalories() {
        return getSmoothieComponents().stream()
                .map(c -> c.getComponent().getKcalPerUnit() * Optional.ofNullable(c.getAmount()).orElse(0L))
                .mapToLong(Long::longValue).sum();
    }
}
