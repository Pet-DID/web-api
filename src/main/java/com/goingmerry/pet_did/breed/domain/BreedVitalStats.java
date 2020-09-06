package com.goingmerry.pet_did.breed.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class BreedVitalStats {

    @Embedded
    private Height height;

    @Embedded
    private Weight weight;

    @Embedded
    private LifeExpectancy lifeExpectancy;
}
