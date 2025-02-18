package com.example.yuagabe.domain.feed.facade;


import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.domain.repository.FeedRepository;
import com.example.yuagabe.domain.feed.exception.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FeedFacade {
    private final FeedRepository feedRepository;

    public Feed getFeed(Long feedId){
        return feedRepository.findById(feedId).orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }

    public List<Feed> getAllFeed(){
        return feedRepository.findAll();
    }
}