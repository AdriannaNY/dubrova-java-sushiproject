package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Cart;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Food;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "cart")
public class JpaCart implements Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private JpaClient client;

    @ManyToMany
    @JoinTable(
            name = "cart_food",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<JpaFood> foods;

    public JpaCart(JpaClient client) {
        this.client = client;
    }

    @Override
    public double getTotalPrice() {
        return foods.stream().mapToDouble(JpaFood::getPrice).sum();
    }

    @Override
    public List<Food> getAllFoods() {
        return new ArrayList<>(foods);
    }

    @Override
    public void addFood(Food food) {
        foods.add(new JpaFood(food.getId(), food.getName(),
                food.getDescription(), food.getPrice()));
    }

    @Override
    public void removeFood(Food food) {
        foods.remove(food);
    }

    @Override
    public void clear() {
        foods.clear();
    }

    @Override
    public String toString() {
        return "JpaCart{" +
                "id=" + id +
                ", client=" + client +
                ", foods=" + foods +
                '}';
    }
}
