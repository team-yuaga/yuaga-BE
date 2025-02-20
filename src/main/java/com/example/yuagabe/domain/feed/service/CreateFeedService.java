package com.example.yuagabe.domain.feed.service;


import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.feed.domain.repository.FeedRepository;
import com.example.yuagabe.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.yuagabe.domain.user.domain.User;
import com.example.yuagabe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CreateFeedService {
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateFeedRequest request) {
        User user = userFacade.getCurrentUser();

        feedRepository.save(Feed.builder()
                .feedLocal(request.getFeedLocal())
                .title(request.getTitle())
                .content(request.getContent())
                .tags(request.getTags())
                .season(request.getSeason())
                .type(request.getType())
                .productName(request.getProductName())
                .purchaseUrl(request.getPurchaseUrl())
                .createdAt(LocalDate.now())
                .user(user)
                .build());
    }
}
