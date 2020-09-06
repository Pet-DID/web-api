package com.goingmerry.pet_did.pet.domain;

import com.goingmerry.pet_did.breed.domain.BreedId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pet")
@Entity
public class Pet {

    @EmbeddedId
    private PetId id;

    @Embedded
    private PetRequiredInfo requiredInfo;

    @Embedded
    private PetBirth birth;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "pet_image", joinColumns = @JoinColumn(name = "image_number"))
    @OrderColumn(name = "list_idx")
    private List<PetImage> images;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "breed_id"))
    )
    private BreedId breedId;

    public Pet(PetId id, PetRequiredInfo requirementInfo) {
        setId(id);
        setRequirementInfo(requirementInfo);
    }

    private void setId(PetId id) {
        if (id == null) throw new IllegalArgumentException("no id");
        this.id = id;
    }

    private void setRequirementInfo(PetRequiredInfo requiredInfo) {
        if (requiredInfo == null) throw new IllegalArgumentException("no required info");
        this.requiredInfo = requiredInfo;
    }

    public void addImage(List<PetImage> images) {
        if (images == null || images.size() == 0) throw new IllegalArgumentException("no images");
        this.images.addAll(images);
    }

    public void setBreed(BreedId breedId) {
        if (breedId == null) throw new IllegalArgumentException("no breed id");
        this.breedId = breedId;
    }
}
