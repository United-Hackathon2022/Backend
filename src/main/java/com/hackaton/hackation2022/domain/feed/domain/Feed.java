package com.hackaton.hackation2022.domain.feed.domain;

import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_feed")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 8, nullable = false)
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
