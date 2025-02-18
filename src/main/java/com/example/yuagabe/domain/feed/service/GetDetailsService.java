package com.example.yuagabe.domain.feed.service;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.facade.FeedFacade;
import com.example.yuagabe.domain.feed.presentation.dto.response.GetDetailsFeedResponse;
import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetDetailsService {
    private final FeedFacade feedFacade;
    private final UserFacade userFacade;

    public GetDetailsFeedResponse execute(Long feedId) {
        Feed feed = feedFacade.getFeed(feedId);
        User user = userFacade.getCurrentUser();

        return new GetDetailsFeedResponse(feed.getTitle(), feed.getContent(), feed.getTags(), feed.getSeason(), user.getNickName(), feed.getCreatedAt(), null);
    }
}
