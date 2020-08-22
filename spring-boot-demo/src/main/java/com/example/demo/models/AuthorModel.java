package com.example.demo.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "authors")
public class AuthorModel implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String nationality;
    @Column
    private String pseudonym;
    @Column
    private LocalDate dateOfBirth;

    public AuthorModel() {
    }

    public AuthorModel(String name, String lastName, String nationality, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
    }

    public AuthorModel(String name, String lastName){
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

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
