package com.goingmerry.pet_did.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 반려동물
 *
 * @author Jin
 *
 */
@Entity
public class Pet {
    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Long id;

    @Id
    @Column(nullable = false, length = 50)
    private String noseprint;                                           // 코지문

    @Id
    @Column(nullable = false, updatable = false, length = 50)
    private String did;                                                 // DID

    @Column(length = 20)
    private String registerNo;                                          // 동물 등록 번호

    @OneToOne(mappedBy = "pet")
    @Column(nullable = false)
    private PetInfo petInfo;                                            // 부가 정보

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;                                                  // 반려인

    @ManyToOne
    @JoinColumn(name = "breed_id", nullable = false)
    private Breed breed;                                                // 품종

    @Column(insertable = false, updatable = false, columnDefinition = "DEFAULT GETDATE()")
    private LocalDateTime registered;                                   // 등록 일자

    @Column(columnDefinition = "DEFAULT NULL")
    private Integer age;                                                // 나이 (null: 확인 안됨)

    @Column(nullable = false)
    private char sex;                                                   // 성별 (F: 암컷, M: 수컷)

    @Column(nullable = false, length = 20)
    private String name;                                                // 이름

    @Column(columnDefinition = "DEFAULT NULL")
    private Date birth;                                                 // 생년월일 (null: 확인 안됨)
}
