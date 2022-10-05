package com.hackaton.hackation2022.domain.user.domain;

import com.hackaton.hackation2022.domain.user.domain.type.Authority;
import com.hackaton.hackation2022.domain.user.domain.type.Sex;
import com.hackaton.hackation2022.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user")
public class User extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 15)
    private String name;

    @NotNull
    @Length(max = 60)
    private String password;

    @NotNull
    @Length(max = 6)
    private String authCode;

    @NotNull
    @Length(max = 1)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    @Length(max = 5)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @NotNull
    private String profileImageUrl;

    @NotNull
    private String firstAge;

    @Builder
    public User(String name, String password, String authCode, Sex sex,
                Authority authority, String profileImageUrl, String firstAge) {
        this.name = name;
        this.password = password;
        this.authCode = authCode;
        this.sex = sex;
        this.authority = authority;
        this.profileImageUrl = profileImageUrl;
        this.firstAge = firstAge;
    }
}
