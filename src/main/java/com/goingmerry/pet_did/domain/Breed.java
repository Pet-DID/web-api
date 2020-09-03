package com.goingmerry.pet_did.domain;

import com.goingmerry.pet_did.domain.pet.Pet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Breed {

    @Id
    @GeneratedValue
    @Column(name = "breed_id")
    private Long id;

    @Column(unique = true, length = 50)
    private String name;

    @OneToMany(mappedBy = "breed")
    private List<Pet> pets = new ArrayList<>();
}
