package com.goingmerry.pet_did.breed.application;

import com.goingmerry.pet_did.breed.domain.BreedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateBreedService {

    private final BreedRepository breedRepository;
}
