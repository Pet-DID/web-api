package com.goingmerry.pet_did.pet.application;

import com.goingmerry.pet_did.pet.domain.Pet;
import com.goingmerry.pet_did.pet.domain.PetId;
import com.goingmerry.pet_did.pet.domain.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreatePetService {

    private final PetIdService petIdService;
    private final PetRepository petRepository;

    @Transactional
    public PetId createPet() {
        PetId id = petIdService.generateId();

        // TODO fill out to build new pet
        Pet pet = Pet.builder()
                .id(id)
                .build();
        petRepository.save(pet);

        return id;
    }
}
