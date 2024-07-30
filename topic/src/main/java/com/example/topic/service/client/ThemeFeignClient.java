package com.example.topic.service.client;

import com.example.topic.dto.ThemeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("theme")
public interface ThemeFeignClient {

    @GetMapping("theme/fetch")
    public ResponseEntity<List<ThemeDto>> fetchThemes();

    @GetMapping("theme/fetch/{id}")
    public ResponseEntity<ThemeDto> fetchTheme(@PathVariable Long id);

}
