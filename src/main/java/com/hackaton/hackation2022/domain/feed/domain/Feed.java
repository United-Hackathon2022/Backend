package com.hackaton.hackation2022.domain.feed.domain;

import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import com.hackaton.hackation2022.domain.user.domain.entity.User;
import com.hackaton.hackation2022.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed")
public class Feed extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 1000)
    private String content;

    @NotNull
    @Length(max = 8)
    @Enumerated(value = EnumType.STRING)
    private FeedType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Feed(String title, String content, FeedType type, User user) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.user = user;
    }
}
