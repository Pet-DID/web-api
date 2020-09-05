package com.goingmerry.pet_did.pet.domain;

public interface PetRepository {

    void save(Pet pet);
    Pet findById(PetId id);
}
