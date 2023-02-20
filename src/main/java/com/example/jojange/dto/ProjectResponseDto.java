package com.example.jojange.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
public class ProjectResponseDto {

    @NotEmpty
    private String projectName;

    private String projectImg;
    private String link;

    @NotEmpty
    private Date startDate;
    @NotEmpty
    private Date endDate;

    public ProjectResponseDto(String projectName, String projectImg, String link, Date startDate, Date endDate) {
        this.projectName = projectName;
        this.projectImg = projectImg;
        this.link = link;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
