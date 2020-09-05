package com.goingmerry.pet_did.pet.application;

import com.goingmerry.pet_did.pet.domain.PetId;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PetIdService {

    public PetId generateId() {
        // TODO in case of complex, implement
        return new PetId(UUID.randomUUID().toString());
    }
}
