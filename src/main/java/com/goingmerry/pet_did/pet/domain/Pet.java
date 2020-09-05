package com.goingmerry.pet_did.pet.domain;

import com.goingmerry.pet_did.breed.domain.Breed;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Table(name = "pet")
@Entity
public class Pet {

    @EmbeddedId
    private PetId id;

    @Embedded
    private PetInfo petInfo;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "pet_image", joinColumns = @JoinColumn(name = "image_number"))
    @OrderColumn(name = "list_idx")
    private List<PetImage> images;

    // FIXME just bread ID
    @ManyToOne
    @JoinColumn(name = "breed_id", nullable = false)
    private Breed breed;

    @Builder
    public Pet(PetId id) {
        this.id = id;
    }
}
