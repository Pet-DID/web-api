package com.goingmerry.pet_did.domain.pet;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PetId implements Serializable {

    @Column(name = "pet_id")
    private String id;

    public PetId(String id) {
        this.id = id;
    }

    // TODO methods for pet id
}
