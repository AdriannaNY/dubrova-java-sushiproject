package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Menu;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
@Setter
@NoArgsConstructor
public class JpaRestaurant implements Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "city")
    @NotNull
    @NotBlank
    private String city;

    @Column(name = "address")
    @NotNull
    @NotBlank
    private String address;

    @Column(name = "phone")
    @NotNull
    @NotBlank
    private String phone;

    @Column(name = "email")
    @Email
    private String email;

    @OneToOne(mappedBy = "restaurant")
    private JpaMenu menu;

    public JpaRestaurant(int id, String name, String city, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "JpaRestaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", menu=" + menu +
                '}';
    }
}
