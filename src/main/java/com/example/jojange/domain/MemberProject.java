package com.example.jojange.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class MemberProject {

    @Id @GeneratedValue
    @Column(name = "member_project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Enumerated(EnumType.STRING)
    private ProjectRole status; // 그룹의 방장과 회원을 나타내는 Column

    private Date selectTime; // 회원이 선택한 시간

}
