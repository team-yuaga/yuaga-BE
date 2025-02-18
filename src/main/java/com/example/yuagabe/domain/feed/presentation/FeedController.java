package com.example.yuagabe.domain.feed.presentation;

import com.example.yuagabe.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.yuagabe.domain.feed.presentation.dto.response.GetFeedResponse;
import com.example.yuagabe.domain.feed.service.CreateFeedService;
import com.example.yuagabe.domain.feed.service.DeleteFeedService;
import com.example.yuagabe.domain.feed.service.GetFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {
    private final CreateFeedService createFeedService;
    private final DeleteFeedService deleteFeedService;
    private final GetFeedService getFeedService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @DeleteMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeed(@PathVariable("feed-id") Long feedId) {
        deleteFeedService.execute(feedId);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GetFeedResponse> getFeed(){
        return getFeedService.execute();
    }
}
