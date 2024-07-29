package com.example.topic.repository;

import com.example.topic.entity.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {
}
