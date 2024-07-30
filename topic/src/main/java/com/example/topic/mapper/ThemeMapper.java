package com.example.topic.mapper;

import com.example.topic.dto.ThemeDto;
import com.example.topic.entity.Theme;

public class ThemeMapper {

    public static ThemeDto toDto(Theme theme) {

        if (theme == null) {
            return null;
        }
        ThemeDto themeDto = new ThemeDto();
        themeDto.setDescription(theme.getDescription());
        themeDto.setThemeId(theme.getThemeId());

        return themeDto;
    }

    public static Theme toEntity(ThemeDto themeDto) {
        if (themeDto == null) {
            return null;
        }
        Theme theme = new Theme();
        theme.setDescription(themeDto.getDescription());
        theme.setThemeId(themeDto.getThemeId());

        return theme;
    }
}
