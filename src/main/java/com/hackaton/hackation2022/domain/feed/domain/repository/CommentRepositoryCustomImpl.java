package com.hackaton.hackation2022.domain.feed.domain.repository;

import com.hackaton.hackation2022.domain.feed.domain.repository.vo.QRelatedCommentVo;
import com.hackaton.hackation2022.domain.feed.domain.repository.vo.CommentVo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hackaton.hackation2022.domain.feed.domain.QComment.comment;
import static com.hackaton.hackation2022.domain.feed.domain.QFeed.feed;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryCustomImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CommentVo> findCommentsListByFeed(Long feedId) {
        return jpaQueryFactory
                .select(new QRelatedCommentVo(
                        comment.content,
                        comment.user.name,
                        comment.user.profileImageUrl
                ))
                .from(comment)
                .join(feed)
                .on(comment.feed.id.eq(feedId))
                .orderBy(comment.id.asc())
                .fetch();
    }
}
