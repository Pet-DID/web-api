package com.goingmerry.pet_did.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 반려동물 정보
 *
 * @author Jin
 *
 */
@Entity
public class PetInfo {

    @Id
    @GeneratedValue
    @Column(name = "pet_info_id")
    private Long id;

    @Column(columnDefinition = "DEFAULT NULL")
    private char neutralized;                                           // 중성화 여부 (Y: 해당, N: 해당 없음, null: 확인 안됨)

    @OneToOne(mappedBy = "petInfo")
    @Column(nullable = false)
    private Alone alone;                                                // 실종/유기 정보

    @Column(nullable = false)
    private String image1;                                              // 반려동물 사진1

    @Column(nullable = false)
    private String image2;                                              // 반려동물 사진2

    @Column(nullable = false)
    private String image3;                                              // 반려동물 사진3

    @Lob
    private String memo;                                                // 기타 특이사항

    @Column(insertable = false)
    private LocalDateTime modified;                                     // 수정 일자

    @Column(nullable = false, columnDefinition = "DEFAULT true")
    private boolean status;                                             // 활성화 상태 (true: 활성화, false: 비활성화)

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
