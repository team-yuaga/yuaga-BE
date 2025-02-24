package com.example.yuagabe.domain.like.presentation;


import com.example.yuagabe.domain.feed.presentation.dto.response.GetFeedResponse;
import com.example.yuagabe.domain.like.presentation.dto.GetMyLikeListResponse;
import com.example.yuagabe.domain.like.service.CreateLikeService;
import com.example.yuagabe.domain.like.service.DeleteLikeService;
import com.example.yuagabe.domain.like.service.GetMyLikeListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/likes")
@RestController
public class LikeController {
    private final CreateLikeService createLikeService;
    private final DeleteLikeService deleteLikeService;
    private final GetMyLikeListService getMyLikeListService;

    @PostMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.OK)
    public void createLike(@PathVariable("feed-id") Long feedId){
        createLikeService.execute(feedId);
    }

    @DeleteMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLike(@PathVariable("feed-id") Long feedId){
        deleteLikeService.execute(feedId);
    }

    @GetMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetMyLikeListResponse> getMyLikeListFeed(@PathVariable("user-id") Long userId){
        return getMyLikeListService.execute(userId);
    }

}
