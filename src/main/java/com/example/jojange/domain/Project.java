package com.example.jojange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id @GeneratedValue
    @Column(name ="project_id")
    private Long id;

    private String projectName;

    private String projectImg;

    private String link;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToMany(mappedBy = "project")
    private List<MemberProject> members = new ArrayList<>();

    // 랜덤 문자열 생성
    public String createLink() {
        int len = 20;
        String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456989";
        int alphaNumLength = alphaNum.length();
        Random random = new Random();
        StringBuffer code = new StringBuffer();

        for (int i=0; i<len; i++) {
            code.append(alphaNum.charAt(random.nextInt(alphaNumLength)));
        }

        return code.toString();
    }
    public Project(String projectName, String projectImg, LocalDateTime startDate, LocalDateTime endDate) {
        this.projectName = projectName;
        this.projectImg = projectImg;
        this.link = createLink();
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
