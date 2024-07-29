package com.example.topic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  @Table(name = "topic") @AllArgsConstructor @Data @NoArgsConstructor
public class Topic extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private int topicId;

    @ManyToOne
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme Theme;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

}