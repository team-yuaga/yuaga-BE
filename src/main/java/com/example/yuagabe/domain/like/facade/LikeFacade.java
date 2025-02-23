package com.example.yuagabe.domain.like.facade;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.like.domain.repository.LikeRepository;
import com.example.yuagabe.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeFacade {
    private final LikeRepository likeRepository;

    public Long countLikesByFeedId(Long feedId) {
        return likeRepository.countByFeedId(feedId);
    }

    public Boolean likeBoolean(Feed feedId, User userId){
        return likeRepository.existsByFeedAndUser(feedId, userId);
    }
}
