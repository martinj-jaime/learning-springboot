package com.example.model;
import java.util.Set;

public class Owner extends Person {
    private Set<Pet> pets;

    public Owner(String firstName, String lastName, Set<Pet> pets) {
        super(firstName, lastName);
        this.pets = pets;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
