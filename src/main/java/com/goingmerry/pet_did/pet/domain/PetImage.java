package com.goingmerry.pet_did.pet.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PetImage {

    @Column(name = "image_type")
    private ImageType type;

    @Column(name = "image_path")
    private String path;

    @Column(name = "update_date", updatable = false)
    private ZonedDateTime updatedAt;

    public enum ImageType {
        THUMBNAIL,
        ;
    }
}
