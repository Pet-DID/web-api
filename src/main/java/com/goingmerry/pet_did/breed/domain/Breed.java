package com.goingmerry.pet_did.breed.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "breed")
@Entity
public class Breed {

    @EmbeddedId
    private BreedId id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "group_name"))
    })
    private BreedGroup group;

    @Embedded
    private BreedSpecification specification;

    @Embedded
    private BreedVitalStats vitalStats;

    public Breed(BreedId id) {
        setId(id);
    }

    private void setId(BreedId id) {
        if (id == null) throw new IllegalArgumentException("no id");
        this.id = id;
    }

    public void setGroup(BreedGroup group) {
        if (group == null) throw new IllegalArgumentException("no group");
        this.group = group;
    }

    public void setSpecification(BreedSpecification specification) {
        if (specification == null) throw new IllegalArgumentException("specification");
        this.specification = specification;
    }

    public void setVitalStats(BreedVitalStats vitalStats) {
        if (vitalStats == null) throw new IllegalArgumentException("vitalStats");
        this.vitalStats = vitalStats;
    }
}
