package com.hackaton.hackation2022.domain.feed.domain;

import com.hackaton.hackation2022.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed_attachment_file")
public class FeedAttachmentFile extends BaseTimeIdEntity {

    @NotNull
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Builder
    public FeedAttachmentFile(String imageUrl, Feed feed) {
        this.imageUrl = imageUrl;
        this.feed = feed;
    }
}
