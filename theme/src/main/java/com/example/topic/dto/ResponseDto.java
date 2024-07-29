package com.example.topic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

    private String statusCode;
    private String timestamp;
    private String statusMsg;
}
