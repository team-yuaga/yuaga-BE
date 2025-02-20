package com.example.yuagabe.domain.feed.service;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.facade.FeedFacade;
import com.example.yuagabe.domain.feed.presentation.dto.response.GetFeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetFeedService {
    private final FeedFacade feedFacade;

    @Transactional
    public List<GetFeedResponse> execute() {
        List<Feed> feeds = feedFacade.getAllFeed();
        return feeds.stream().map(feed -> new GetFeedResponse(feed.getId(), feed.getTitle(), feed.getTags(), feed.getCreatedAt())).toList();
    }
}
