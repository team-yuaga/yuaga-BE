package com.example.yuagabe.domain.like.facade;

import com.example.yuagabe.domain.like.domain.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeFacade {
    private final LikeRepository likeRepository;

    public Long countLikesByFeedId(Long feedId) {
        return likeRepository.countByFeedId(feedId);
    }
}
