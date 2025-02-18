package com.example.yuagabe.domain.feed.presentation.dto.response;


import com.example.yuagabe.domain.feed.domain.Season;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class GetDetailsFeedResponse {
    private final String title;
    private final String content;
    private final List<String> tags;
    private final Season season;
    private final String nickname;
    private final LocalDate createdAt;
    private final Long like;

    public GetDetailsFeedResponse(String title, String content, List<String> tags, Season season, String nickname, LocalDate createdAt, Long like){
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.season = season;
        this.nickname = nickname;
        this.createdAt = createdAt;
        this.like = like;
    }
}
