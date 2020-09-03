package com.goingmerry.pet_did.domain.pet;

import com.goingmerry.pet_did.domain.Breed;
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

    @ElementCollection
    @CollectionTable(name = "pet_image", joinColumns = @JoinColumn(name = "image_number"))
    @OrderColumn(name = "list_idx")
    private List<PetImage> images;

    // FIXME just bread ID
    @ManyToOne
    @JoinColumn(name = "breed_id", nullable = false)
    private Breed breed;
}
