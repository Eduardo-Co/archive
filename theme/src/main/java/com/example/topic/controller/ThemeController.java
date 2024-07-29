package com.example.topic.controller;

import com.example.topic.dto.ResponseDto;
import com.example.topic.dto.ThemeDto;
import com.example.topic.service.IThemeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Validated
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private HttpServletRequest request;
    private final IThemeService themeService;

    @Autowired
    public ThemeController(IThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createTheme(@Valid @RequestBody ThemeDto themeDto) {

        themeService.createTheme(themeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", LocalDateTime.now().toString(), "Theme created successfully"));
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<ThemeDto>> fetchThemes() {

        List<ThemeDto> themeList = themeService.getAllThemes();

        for (ThemeDto themeDto : themeList) {
            themeDto.setUrl(request.getRequestURL()+"/"+themeDto.getThemeId());

        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(themeList);
    }


    @GetMapping("/fetch/{id}")
    public ResponseEntity<ThemeDto> fetchTheme(@PathVariable Long id) {

        ThemeDto themeDto = themeService.getThemeById(id);
        themeDto.setUrl(String.valueOf(request.getRequestURL()));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(themeDto);

    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteTheme(@PathVariable Long id) {

        themeService.deleteTheme(id);
        ResponseDto responseDto = new ResponseDto("204", LocalDateTime.now().toString(), "Theme deleted");


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateTheme(@PathVariable Long id, @Valid @RequestBody ThemeDto themeDto) {

        themeDto.setThemeId(id);

        themeService.updateTheme(themeDto);

        ResponseDto responseDto = new ResponseDto("204", LocalDateTime.now().toString(), "Theme updated successfully");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }
}
