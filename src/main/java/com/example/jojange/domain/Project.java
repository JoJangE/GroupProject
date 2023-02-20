package com.example.jojange.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="project_id")
    private Long id; //PK

    public Project(String projectName, String projectImg, String link, Date startDate, Date endDate) {
        this.projectName = projectName;
        this.projectImg = projectImg;
        this.link = link;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project() {
    }

    private String projectName;
    private String projectImg;//project img url
    private String link;
    private Date startDate;
    private Date endDate;

}
