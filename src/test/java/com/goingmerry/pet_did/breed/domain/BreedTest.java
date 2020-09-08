package com.goingmerry.pet_did.breed.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BreedTest {

    @Test
    public void construct() {
        String breedName = "test";
        final BreedId id = new BreedId(breedName);

        final Breed breed = new Breed(id);

        assertEquals(breedName, breed.getId().value());
    }
}