package com.example.topic.controller;


import com.example.topic.dto.ResponseDto;
import com.example.topic.dto.TopicDto;
import com.example.topic.service.ITopicService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Validated
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ITopicService iTopicService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createTheme(@RequestBody TopicDto topicDto){

        iTopicService.createTheme(topicDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", LocalDateTime.now().toString(), "Topic created successfully"));
    }

}
