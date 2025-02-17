package com.example.yuagabe.domain.feed.presentation;


import com.example.yuagabe.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.yuagabe.domain.feed.service.CreateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {
    private final CreateFeedService createFeedService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createFeed(@RequestBody @Valid CreateFeedRequest request){
        createFeedService.execute(request);
    }
}
