package com.goingmerry.pet_did.domain;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 반려인
 *
 * @author Jin
 *
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String kakaoId;                         // 카카오 아이디

    @Column(nullable = false, length = 11)
    private String name;                            // 이름

    @Column(nullable = false, length = 20)
    private String nickname;                        // 닉네임

    @Column(nullable = false, length = 20)
    private String phone;                           // 전화 번호

    @Column(insertable = false, updatable = false, columnDefinition = "DEFAULT GETDATE()")
    private LocalDateTime registered;               // 등록 일자

    @Column(columnDefinition = "DEFAULT true")
    private boolean status;                         // 활성화 상태 (true: 활성화, false: 비활성화)

    @OneToMany(mappedBy = "user")
    private List<Pet> pets = new ArrayList<>();     // 반려동물
}
