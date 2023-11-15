package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.jpa;

import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Cart;
import com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@NoArgsConstructor
public class JpaClient implements Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Pattern(regexp = "[A-Z][a-z]{2,}")
    private String name;

    @Column(name = "age")
    @Min(value = 18)
    @Max(value = 110)
    private int age;

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

    @OneToOne(mappedBy = "client")
    private JpaCart cart;

    public JpaClient(int id, String name, int age, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
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
    public int getAge() {
        return age;
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
    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "JpaClient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", cart=" + cart +
                '}';
    }
}

