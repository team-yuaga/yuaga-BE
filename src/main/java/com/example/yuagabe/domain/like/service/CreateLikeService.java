package com.example.yuagabe.domain.like.service;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.facade.FeedFacade;
import com.example.yuagabe.domain.like.domain.Like;
import com.example.yuagabe.domain.like.domain.repository.LikeRepository;
import com.example.yuagabe.domain.like.exception.AlreadyExistsLikeException;
import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateLikeService {
    private final LikeRepository likeRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    public void execute(Long feedId){
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(feedId);

        boolean isExistLike = likeRepository.existsByFeedAndUser(feed, user);
        if (isExistLike) {
            throw AlreadyExistsLikeException.EXCEPTION;
        }

        likeRepository.save(new Like(feed, user));
    }
}
