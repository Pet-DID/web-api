package com.goingmerry.pet_did.pet.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PetRequiredInfo {

    @Column(name = "name")
    private String name;

    public PetRequiredInfo(String name) {
        this.name = name;
    }
}
