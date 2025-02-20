package com.example.yuagabe.domain.like.domain.repository;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.like.domain.Like;
import com.example.yuagabe.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like getByFeedAndUser(Feed feed, User user);

    boolean existsByFeedAndUser(Feed feed, User user);

    Long countByFeedId(Long feedId);
}
