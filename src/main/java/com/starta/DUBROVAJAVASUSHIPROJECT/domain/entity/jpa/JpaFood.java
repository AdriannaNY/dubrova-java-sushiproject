package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Food;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaFood implements Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Pattern(regexp = "[A-Z][a-z]{2,}")
    private String name;

    @Column(name = "description")
    @NotNull
    @NotBlank
    private String description;

    @Column(name = "price")
    @Min(value = 1)
    @Max(value = 999999)
    private double price;

    @Override
    public String toString() {
        return "JpaFood{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", price='" + price + '\'' +
                '}';
    }
}
