package com.example.yuagabe.domain.feed.domain.repository;

import com.example.yuagabe.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedLocalRepository extends JpaRepository<Feed, String> {
}
