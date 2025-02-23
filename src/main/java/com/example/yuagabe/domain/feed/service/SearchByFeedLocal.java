package com.example.yuagabe.domain.feed.service;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.domain.FeedLocal;
import com.example.yuagabe.domain.feed.domain.repository.FeedRepository;
import com.example.yuagabe.domain.feed.presentation.dto.response.GetFeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchByFeedLocal {
    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public List<GetFeedResponse> execute(FeedLocal feedLocal) {
        List<Feed> feeds = feedRepository.searchByFeedLocal(feedLocal);
        return feeds.stream()
                .map(feed -> GetFeedResponse.builder()
                        .feedId(feed.getId())
                        .title(feed.getTitle())
                        .tags(feed.getTags())
                        .cateGory(feed.getFeedLocal()
                        )
                        .season(feed.getSeason())
                        .build())
                .sorted(Comparator.comparingLong(GetFeedResponse::getFeedId).reversed())
                .collect(Collectors.toList());
    }
}
