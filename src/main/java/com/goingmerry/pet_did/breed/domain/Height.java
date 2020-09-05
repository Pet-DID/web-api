package com.goingmerry.pet_did.breed.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Height {

    @Column(name = "height_unit")
    private String unit; // TODO type for unit

    @Column(name = "height_low")
    private float low;

    @Column(name = "height_high")
    private float high;
}
