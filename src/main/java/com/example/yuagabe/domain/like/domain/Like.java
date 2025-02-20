package com.example.yuagabe.domain.like.domain;


import com.example.yuagabe.domain.feed.domain.Feed;
import com.example.yuagabe.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "tbl_like",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"feed_id", "user_id"})
        },
        indexes = {
                @Index(columnList = "feed_id"),
                @Index(columnList = "user_id")
        }
)
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", columnDefinition = "BIGINT", nullable = false)
    private Feed feed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BIGINT", nullable = false)
    private User user;

    public Like(Feed feed, User user) {
        this.feed = feed;
        this.user = user;
    }
}
