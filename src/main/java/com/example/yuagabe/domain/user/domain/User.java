package com.example.yuagabe.domain.user.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String accountId;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String nickName;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(20)")
    private Long height;

    @Column(columnDefinition = "varchar(20)")
    private Long weight;

    @Column(columnDefinition = "TEXT")
    private String skin;

    @Column(columnDefinition = "TEXT")
    private String style;

    @Column(name = "personal_color", columnDefinition = "varchar(255)")
    @Enumerated(EnumType.STRING)
    private UserPersonalColor userPersonalColor;

    public void changeNickname(String nickName) {
        this.nickName = nickName;
    }

    public void UserInformation(Long height, Long weight, String skin, String style, UserPersonalColor userPersonalColor) {
        this.height = height;
        this.weight = weight;
        this.skin = skin;
        this.style = style;
        this.userPersonalColor = userPersonalColor;
    }
}
