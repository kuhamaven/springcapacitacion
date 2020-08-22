package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column
    private String name;
    @Column
    private String lastName;

    public UserModel() {
    }

    public UserModel(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
