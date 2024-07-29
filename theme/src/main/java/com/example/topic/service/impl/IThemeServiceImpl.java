package com.example.topic.service.impl;

import com.example.topic.dto.ThemeDto;
import com.example.topic.entity.Theme;
import com.example.topic.exception.ResourceNotFoundException;
import com.example.topic.mapper.ThemeMapper;
import com.example.topic.repository.ThemeRepository;
import com.example.topic.service.IThemeService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IThemeServiceImpl implements IThemeService {

    private final ThemeRepository themeRepository;

    public IThemeServiceImpl(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @Override
    public void createTheme(ThemeDto themeDto) {

        Theme theme = ThemeMapper.toEntity(themeDto);
        themeRepository.save(theme);

    }

    @Override
    public List<ThemeDto> getAllThemes() {


        List<Theme> themeList = (List<Theme>) themeRepository.findAll();

        return themeList.stream()
                .map(ThemeMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public ThemeDto getThemeById(Long themeId) {

        Theme theme = themeRepository.findById(themeId).orElseThrow(
                () -> new ResourceNotFoundException("Theme", "id", String.valueOf(themeId))
        );

        return ThemeMapper.toDto(theme);
    }

    @Override
    public void deleteTheme(Long themeId) {

        themeRepository.findById(themeId).orElseThrow(
                () -> new ResourceNotFoundException("Theme", "id", String.valueOf(themeId))
        );
       themeRepository.deleteById(themeId);
    }

    @Override
    public void updateTheme(ThemeDto themeDto) {

        Theme theme = ThemeMapper.toEntity(themeDto);
        themeRepository.findById((long) theme.getThemeId()).orElseThrow(
                () -> new ResourceNotFoundException("Theme", "id", String.valueOf(theme.getThemeId()))
        );

        themeRepository.save(theme);
    }
}
