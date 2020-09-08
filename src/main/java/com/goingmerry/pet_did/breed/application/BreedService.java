package com.goingmerry.pet_did.breed.application;

import com.goingmerry.pet_did.breed.domain.Breed;
import com.goingmerry.pet_did.breed.domain.BreedId;
import com.goingmerry.pet_did.breed.domain.BreedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BreedService {

    private final BreedRepository breedRepository;

    @Transactional
    public String create(String id) {
        Breed breed = new Breed(new BreedId(id));
        breedRepository.save(breed);

        return id;
    }

    @Transactional(readOnly = true)
    public Breed find(String id) {
        return breedRepository.findById(new BreedId(id));
    }
}
