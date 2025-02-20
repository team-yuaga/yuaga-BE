package com.example.yuagabe.domain.feed.presentation.dto.response;

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
    private final LocalDate createdAt;

    public GetFeedResponse(Long feedId, String title, List<String> tags, LocalDate createdAt){
        this.feedId = feedId;
        this.title = title;
        this.tags = tags;
        this.createdAt = createdAt;
    }
}
