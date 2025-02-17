package com.example.yuagabe.domain.feed.domain;


import com.example.yuagabe.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_feed")
@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_id")
    private Long id;

    @Column(name = "feed_local", columnDefinition = "varchar(10)", nullable = false)
    private FeedLocal feedLocal;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String title;

    @ElementCollection
    @CollectionTable(name = "feed_tags", joinColumns = @JoinColumn(name = "feed_id"))
    @Column(columnDefinition = "varchar(255)")
    private List<String> tags;

    @Column(columnDefinition = "varchar(10)")
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Feed(FeedLocal feedLocal, String title, List<String> tags, Season season, User user){
        this.feedLocal = feedLocal;
        this.title = title;
        this.tags = tags;
        this.season = season;
        this.user = user;
    }
}

