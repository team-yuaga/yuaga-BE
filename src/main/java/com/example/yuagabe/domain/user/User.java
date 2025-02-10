package com.example.yuagabe.domain.user;

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
    private String accountId;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String nickName;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(6)")
    private String height;

    @Column(columnDefinition = "varchar(6)")
    private String weight;

    @Column(columnDefinition = "TEXT")
    private String skin;

    @Column(columnDefinition = "TEXT")
    private String style;

    @Column(name = "personal_color", columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private String UserPersonalColor;
}
