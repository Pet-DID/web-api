package com.goingmerry.pet_did.breed.infra.repository;

import com.goingmerry.pet_did.breed.domain.Breed;
import com.goingmerry.pet_did.breed.domain.BreedId;
import com.goingmerry.pet_did.breed.domain.BreedRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaBreedRepository implements BreedRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Breed breed) {
        entityManager.persist(breed);
    }

    @Override
    public Breed findById(BreedId id) {
        return entityManager.find(Breed.class, id);
    }

    @Override
    public List<Breed> findByGroupName(String groupName) {
        TypedQuery<Breed> query = entityManager.createQuery(
                "SELECT b FROM Breed b " +
                        "WHERE b.group.name = :groupName ",
                Breed.class);
        query.setParameter("groupName", groupName);

        return query.getResultList();
    }
}
