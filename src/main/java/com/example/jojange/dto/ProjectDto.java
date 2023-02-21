package com.example.jojange.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ProjectDto {
    private String projectName;
    private String projectImg;
    private String link;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}


