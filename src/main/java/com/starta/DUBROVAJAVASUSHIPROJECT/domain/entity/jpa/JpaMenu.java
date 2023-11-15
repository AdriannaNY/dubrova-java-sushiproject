package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Food;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Menu;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
@NoArgsConstructor
public class JpaMenu implements Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private JpaRestaurant restaurant;

    @ManyToMany
    @JoinTable(
            name = "menu_food",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<JpaFood> foods;

    public JpaMenu(JpaRestaurant restaurant) {
        this.restaurant = restaurant;
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
        foods.add(new JpaFood(food.getId(), food.getName(), food.getDescription(), food.getPrice()));
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
        return "JpaMenu{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", foods=" + foods +
                '}';
    }
}
