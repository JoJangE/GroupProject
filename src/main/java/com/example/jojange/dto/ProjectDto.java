package com.example.jojange.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
public class ProjectDto {

    @NotEmpty
    private String projectName;

    private String projectImg;
    private String link;

    @NotEmpty
    private Date startDate;
    @NotEmpty
    private Date endDate;
}
