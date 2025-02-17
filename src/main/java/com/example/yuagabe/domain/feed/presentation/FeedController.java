package com.example.yuagabe.domain.feed.presentation;

import com.example.yuagabe.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.yuagabe.domain.feed.service.CreateFeedService;
import com.example.yuagabe.domain.feed.service.DeleteFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {
    private final CreateFeedService createFeedService;
    private final DeleteFeedService deleteFeedService;

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
}
