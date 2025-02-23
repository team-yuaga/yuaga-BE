package com.example.yuagabe.domain.feed.presentation.dto.response;

import com.example.yuagabe.domain.feed.domain.FeedLocal;
import com.example.yuagabe.domain.feed.domain.Season;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class GetFeedResponse {
    private final Long feedId;
    private final String title;
    private final List<String> tags;
    private final FeedLocal cateGory;
    private final Season season;
    private final LocalDate createdAt;
    private final Boolean likeBoolean;

    public GetFeedResponse(Long feedId, String title, List<String> tags, FeedLocal cateGory, Season season, LocalDate createdAt, Boolean likeBoolean) {
        this.feedId = feedId;
        this.title = title;
        this.tags = tags;
        this.cateGory = cateGory;
        this.season = season;
        this.createdAt = createdAt;
        this.likeBoolean = likeBoolean;
    }
}
