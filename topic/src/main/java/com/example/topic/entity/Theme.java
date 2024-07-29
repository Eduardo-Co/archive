package com.example.topic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  @Table(name = "theme") @AllArgsConstructor @Data @NoArgsConstructor @Builder
public class Theme extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id")
    private long themeId;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

}
