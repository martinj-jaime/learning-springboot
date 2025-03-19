package com.example.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {
    @Column(name = "name")
    private String name;

    public PetType() {}

    public PetType(Long id) {
        super(id);
    }

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
