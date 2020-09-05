package com.goingmerry.pet_did.pet.infra.repository;

import com.goingmerry.pet_did.pet.domain.Pet;
import com.goingmerry.pet_did.pet.domain.PetId;
import com.goingmerry.pet_did.pet.domain.PetRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaPetRepository implements PetRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Pet pet) {
        entityManager.persist(pet);
    }

    @Override
    public Pet findById(PetId id) {
        return entityManager.find(Pet.class, id);
    }
}
