package com.goingmerry.pet_did.pet.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PetBirth {

    @Column(name = "pet_birth")
    private ZonedDateTime date;

    protected int getYear() {
        return this.date.getYear();
    }

    protected int getMonth() {
        return this.date.getMonth().getValue();
    }

    protected int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }
}
