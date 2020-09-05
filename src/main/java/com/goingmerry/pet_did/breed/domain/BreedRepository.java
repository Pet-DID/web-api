package com.goingmerry.pet_did.breed.domain;

import java.util.List;

public interface BreedRepository {

    void save(Breed breed);

    Breed findById(BreedId id);

    List<Breed> findByGroupName(String groupName);
}
