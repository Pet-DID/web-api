package com.goingmerry.pet_did.breed.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class BreedGroup {

    @Column(name = "name")
    private String name;

    public BreedGroup(String name) {
        this.name = name;
    }
}
