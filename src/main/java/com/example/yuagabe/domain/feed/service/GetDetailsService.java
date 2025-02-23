package com.example.yuagabe.domain.feed.service;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.facade.FeedFacade;
import com.example.yuagabe.domain.feed.presentation.dto.response.GetDetailsFeedResponse;
import com.example.yuagabe.domain.like.domain.Like;
import com.example.yuagabe.domain.like.facade.LikeFacade;
import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetDetailsService {
    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final LikeFacade likeFacade;

    public GetDetailsFeedResponse execute(Long feedId) {
        Feed feed = feedFacade.getFeed(feedId);
        User user = userFacade.getCurrentUser();
        Long like = likeFacade.countLikesByFeedId(feedId);

        return new GetDetailsFeedResponse(feed.getId(),user.getId(), feed.getTitle(), feed.getContent(), feed.getTags(), feed.getSeason(), user.getNickName(), feed.getCreatedAt(), like, feed.getType(), feed.getProductName(), feed.getPurchaseUrl());
    }
}
