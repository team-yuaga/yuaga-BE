package com.example.yuagabe.domain.feed.service;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.facade.FeedFacade;
import com.example.yuagabe.domain.feed.presentation.dto.response.GetFeedResponse;
import com.example.yuagabe.domain.like.domain.repository.LikeRepository;
import com.example.yuagabe.domain.like.facade.LikeFacade;
import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetFeedService {
    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final LikeRepository likeRepository;

    @Transactional
    public List<GetFeedResponse> execute() {
        List<Feed> feeds = feedFacade.getAllFeed();
        User user = userFacade.getCurrentUser();
        return feeds.stream().map(feed -> new GetFeedResponse(feed.getId(), feed.getTitle(), feed.getTags(), feed.getCreatedAt(), likeRepository.existsByFeedAndUser(feed, user))).toList();
    }
}
