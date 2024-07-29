package com.example.topic.mapper;

import com.example.topic.dto.TopicDto;
import com.example.topic.entity.Theme;
import com.example.topic.entity.Topic;

public class TopicMapper {

    public static TopicDto toDto(Topic topic) {
        return new TopicDto(
                topic.getTopicId(),
                topic.getTheme() != null ? topic.getTheme().getThemeId() : null,
                topic.getTitle(),
                topic.getContent()
        );
    }
    public static Topic toEntity(TopicDto topicDto, Theme theme) {
        Topic topic = new Topic();
        topic.setTopicId(topicDto.getTopicId());
        topic.setTheme(theme);
        topic.setTitle(topicDto.getTitle());
        topic.setContent(topicDto.getContent());
        return topic;
    }
}
