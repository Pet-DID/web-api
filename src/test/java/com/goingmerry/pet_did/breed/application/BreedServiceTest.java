package com.goingmerry.pet_did.breed.application;

import com.goingmerry.pet_did.SpringTestSupport;
import com.goingmerry.pet_did.breed.domain.Breed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BreedServiceTest extends SpringTestSupport {

    @Autowired BreedService breedService;

    @Test
    public void findById() {
        String id = breedService.create("test1");

        Breed breed = breedService.find(id);

        assertEquals("test1", breed.getId().value());
    }
}