package com.example.yuagabe.domain.feed.service;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.domain.repository.FeedRepository;
import com.example.yuagabe.domain.feed.exception.CannotDeleteFeedException;
import com.example.yuagabe.domain.feed.facade.FeedFacade;
import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {
    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final FeedRepository feedRepository;

    @Transactional
    public void execute(Long feedId){
        Feed feed = feedFacade.getFeed(feedId);
        User user = userFacade.getCurrentUser();

        if(!user.equals(feed.getUser())) {
            throw CannotDeleteFeedException.EXCEPTION;
        }

        feedRepository.delete(feed);
    }
}
