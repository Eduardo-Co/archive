package com.example.topic.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeDto {

    private long themeId;

    @NotBlank(message = "The description cannot be blank")
    private String description;

    private String url;

}
