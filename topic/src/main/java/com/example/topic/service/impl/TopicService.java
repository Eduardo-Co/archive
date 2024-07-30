package com.example.topic.service.impl;

import com.example.topic.dto.ThemeDto;
import com.example.topic.dto.TopicDto;
import com.example.topic.entity.Theme;
import com.example.topic.entity.Topic;
import com.example.topic.exception.ResourceNotFoundException;
import com.example.topic.mapper.ThemeMapper;
import com.example.topic.mapper.TopicMapper;
import com.example.topic.repository.TopicRepository;
import com.example.topic.service.ITopicService;
import com.example.topic.service.client.ThemeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TopicService implements ITopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ThemeFeignClient themeFeignClient;

    @Override
    public void createTheme(TopicDto topicDto) {

        ResponseEntity<ThemeDto> themeResponse = themeFeignClient.fetchTheme(topicDto.getThemeId());

        if (themeResponse.getStatusCode() == HttpStatus.OK && themeResponse.getBody() != null) {
            ThemeDto themeDto = themeResponse.getBody();
            Theme theme = ThemeMapper.toEntity(themeDto);
            Topic topic = TopicMapper.toEntity(topicDto,theme);
            topicRepository.save(topic);

        } else {
            throw new ResourceNotFoundException("Theme", "ThemeId", String.valueOf(topicDto.getThemeId()));
        }
    }

}
