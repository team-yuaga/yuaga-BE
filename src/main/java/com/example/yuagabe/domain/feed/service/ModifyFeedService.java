package com.example.yuagabe.domain.feed.service;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.facade.FeedFacade;
import com.example.yuagabe.domain.feed.presentation.dto.request.ModifyFeedRequest;
import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ModifyFeedService {
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    public void execute(ModifyFeedRequest request) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeed(request.getFeedId());

        feed.ModifyFeed(request.getFeedLocal(), request.getTitle(), request.getContent(), request.getTags(), request.getSeason(), user);
    }
}
