package com.goingmerry.pet_did.breed.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class BreedSpecification {

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_level")
    private ActivityLevel activityLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "barking_level")
    private BarkingLevel barkingLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "coat_type")
    private CoatType coatType;

    @Enumerated(EnumType.STRING)
    @Column(name = "shedding")
    private Shedding shedding;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private Size size;

    // characteristics
    // train ability
}
