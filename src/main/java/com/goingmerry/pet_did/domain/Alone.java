package com.goingmerry.pet_did.domain;

import javax.persistence.*;

/**
 * 실종/유기 정보
 *
 * @author  Jin
 *
 */
@Entity
public class Alone {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;                // 반려 동물 정보

    @Enumerated(EnumType.STRING)
    private Region region;          // 실종/유기 장소

    @Lob
    private String memo;            // 상세 설명
    @Column(columnDefinition = "DEFAULT NULL")
    private char status;            // 상태 (null: 해당 없음 Y: 실종/유기 상태)

    public enum Region {
        SEOUL,
        BUSAN,
        DAEGU,
        INCHEON,
        GWANGJU,
        DAEJEON,
        ULSAN,
        SAEJONG,
        GYUNGGI,
        GANGWON,
        CHUNGCHEONG_BUKDO,
        CHUNGCHEONG_NAMDO,
        JEONLA_NAMDO,
        JEONLA_BUKDO,
        GYUNGSANG_BUKDO,
        GYUNGSANG_NAMDO,
        JEJU
    }
}
