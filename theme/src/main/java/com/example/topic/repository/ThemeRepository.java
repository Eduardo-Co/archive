package com.example.topic.repository;

import com.example.topic.entity.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {
}
