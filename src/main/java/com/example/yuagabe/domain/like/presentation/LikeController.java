package com.example.yuagabe.domain.like.presentation;


import com.example.yuagabe.domain.like.service.CreateLikeService;
import com.example.yuagabe.domain.like.service.DeleteLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/likes")
@RestController
public class LikeController {
    private final CreateLikeService createLikeService;
    private final DeleteLikeService deleteLikeService;

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

}
