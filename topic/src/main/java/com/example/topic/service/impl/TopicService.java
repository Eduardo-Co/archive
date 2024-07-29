package com.example.topic.service.impl;

import com.example.topic.dto.TopicDto;
import com.example.topic.repository.TopicRepository;
import com.example.topic.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService implements ITopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void createTheme(TopicDto topicDto) {



    }

}
