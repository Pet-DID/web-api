package com.goingmerry.pet_did.breed.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class LifeExpectancy {

    @Column(name = "life_expectancy_unit")
    private String unit; // TODO type for unit

    @Column(name = "life_expectancy_low")
    private float low;

    @Column(name = "life_expectancy_high")
    private float high;
}
