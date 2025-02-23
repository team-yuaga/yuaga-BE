package com.example.yuagabe.domain.feed.domain;

import com.example.yuagabe.domain.user.domain.User;
import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(columnDefinition = "varchar(500)")
    private String content;

    @ElementCollection
    @CollectionTable(name = "feed_tags", joinColumns = @JoinColumn(name = "feed_id"))
    @Column(columnDefinition = "varchar(255)")
    private List<String> tags;

    @Column(columnDefinition = "varchar(10)")
    private Season season;

    @Column(columnDefinition = "varchar(50)")
    private String type;

    @Column(name = "product_name", columnDefinition = "varchar(50)")
    private String productName;

    @Column(name = "purchase_url", columnDefinition = "varchar(500)")
    private String purchaseUrl;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void ModifyFeed(FeedLocal feedLocal, String title, String content, List<String> tags, Season season, String type, String productName, String purchaseUrl, User user) {
        this.feedLocal = feedLocal;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.season = season;
        this.type = type;
        this.productName = productName;
        this.purchaseUrl = purchaseUrl;
        this.updatedAt = LocalDate.now();
        this.user = user;
    }
}

