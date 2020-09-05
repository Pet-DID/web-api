package com.goingmerry.pet_did.breed.infra.repository;

import com.goingmerry.pet_did.breed.domain.Breed;
import com.goingmerry.pet_did.breed.domain.BreedId;
import com.goingmerry.pet_did.breed.domain.BreedRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaBreedRepository implements BreedRepository {

    @Override
    public void save(Breed breed) {

    }

    @Override
    public Breed findById(BreedId id) {
        return null;
    }

    @Override
    public List<Breed> findByGroupName(String groupName) {
        return null;
    }
}
