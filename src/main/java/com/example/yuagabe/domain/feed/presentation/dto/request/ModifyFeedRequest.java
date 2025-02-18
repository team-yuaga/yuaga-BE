package com.example.yuagabe.domain.feed.presentation.dto.request;


import com.example.yuagabe.domain.feed.domain.FeedLocal;
import com.example.yuagabe.domain.feed.domain.Season;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ModifyFeedRequest {
    private Long feedId;
    private FeedLocal feedLocal;
    private String title;
    private String content;
    private List<String> tags;
    private Season season;
}
