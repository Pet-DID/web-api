package com.goingmerry.pet_did.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 품종
 *
 * @author Jin
 *
 */
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
