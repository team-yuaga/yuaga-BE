package com.example.yuagabe.domain.like.service;

import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.like.domain.repository.LikeRepository;
import com.example.yuagabe.domain.like.presentation.dto.GetMyLikeListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetMyLikeListService {
    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public List<GetMyLikeListResponse> execute(Long userId) {
        return likeRepository.findByUserId(userId).stream()
                .map(like -> {
                    Feed feed = like.getFeed();
                    return new GetMyLikeListResponse(
                            feed.getId(),
                            feed.getTitle(),
                            feed.getTags(),
                            feed.getFeedLocal(),
                            feed.getSeason(),
                            feed.getCreatedAt(),
                            true
                    );
                })
                .collect(Collectors.toList());
    }
}
