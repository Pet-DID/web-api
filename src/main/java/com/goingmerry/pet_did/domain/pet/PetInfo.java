package com.goingmerry.pet_did.domain.pet;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PetInfo {

    // TODO polish

    @Column(name = "neutralized", columnDefinition = "DEFAULT NULL")
    private char neutralized;

    @Lob
    @Column(name = "memo")
    private String memo;

    @Column(name = "modified", insertable = false)
    private LocalDateTime modified;

    @Column(name = "status", nullable = false, columnDefinition = "DEFAULT true")
    private boolean status;

    @Column(name = "noseprint")
    private String noseprint;

    @Column(name = "did")
    private String did;

    @Column(name = "register_no")
    private String registerNo;

    @Column(name = "registered", insertable = false, updatable = false, columnDefinition = "DEFAULT GETDATE()")
    private LocalDateTime registered;

    @Column(name = "age", columnDefinition = "DEFAULT NULL")
    private Integer age;

    @Column(name = "sex", nullable = false)
    private char sex;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "birth", columnDefinition = "DEFAULT NULL")
    private Date birth;
}
