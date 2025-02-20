package com.example.yuagabe.domain.feed.presentation.dto.request;

import com.example.yuagabe.domain.feed.domain.FeedLocal;
import com.example.yuagabe.domain.feed.domain.Season;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {
    @NotNull(message = "feed_local은 Null이 불가합니다.")
    private FeedLocal feedLocal;

    @NotNull(message = "title은 Null이 불가합니다.")
    @Size(max = 100, message = "title은 최대 100글자 입니다.")
    private String title;

    private String content;

    private List<String> tags;

    private Season season;

    private String type;

    private String productName;

    private String purchaseUrl;
}
