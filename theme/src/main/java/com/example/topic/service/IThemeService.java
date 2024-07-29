package com.example.topic.service;

import com.example.topic.dto.ThemeDto;

import java.util.List;

public interface IThemeService {

    void createTheme(ThemeDto themeDto);

    List<ThemeDto> getAllThemes();

    ThemeDto getThemeById(Long themeId);

    void deleteTheme(Long themeId);

    void updateTheme(ThemeDto themeDto);
}
