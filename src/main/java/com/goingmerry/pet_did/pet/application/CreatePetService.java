package com.goingmerry.pet_did.pet.application;

import com.goingmerry.pet_did.pet.domain.Pet;
import com.goingmerry.pet_did.pet.domain.PetId;
import com.goingmerry.pet_did.pet.domain.PetRepository;
import com.goingmerry.pet_did.pet.domain.PetRequiredInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreatePetService {

    private final PetIdService petIdService;
    private final PetRepository petRepository;

    @Transactional
    public PetId createPet(String petName) {
        PetId id = petIdService.generateId();
        PetRequiredInfo requiredInfo = new PetRequiredInfo(petName);

        // TODO add extra info, just id and required info
        Pet pet = new Pet(id, requiredInfo);
        petRepository.save(pet);

        return id;
    }
}
