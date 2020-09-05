package com.goingmerry.pet_did.breed.domain;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Breed {

    @EmbeddedId
    private BreedId id;

    @Embedded
    private BreedGroup group;

    @Embedded
    private BreedSpecification specification;

    @Embedded
    private VitalStats vitalStats;
}
