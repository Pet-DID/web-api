package com.goingmerry.pet_did.breed.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class BreedId implements Serializable {

    @Column(name = "name")
    private String id;

    public BreedId(String id) {
        this.id = id;
    }

    public String value() {
        return this.id;
    }
}
