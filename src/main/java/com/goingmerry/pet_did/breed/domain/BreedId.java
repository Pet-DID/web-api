package com.goingmerry.pet_did.breed.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class BreedId implements Serializable {

    @Column(name = "name")
    private String id;

    // TODO search for breed group

    public BreedId(String id) {
        this.id = id;
    }

    // TODO methods for breed id
}
