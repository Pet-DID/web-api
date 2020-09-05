package com.goingmerry.pet_did.breed.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Weight {

    @Column(name = "weight_unit")
    private String unit; // TODO type for unit

    @Column(name = "weight_low")
    private float low;

    @Column(name = "weight_high")
    private float high;
}
