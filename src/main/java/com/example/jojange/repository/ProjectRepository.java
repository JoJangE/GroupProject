package com.example.jojange.repository;

import com.example.jojange.domain.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
@RequiredArgsConstructor
public class ProjectRepository {

    private final EntityManager em;

    // 프로젝트 생성
    public Project createProject(String projectName, String projectImg, LocalDateTime startDate, LocalDateTime endDate) {
        Project project = new Project(projectName, projectImg, startDate, endDate);
        em.persist(project);
        return project;
    }

    // 프로젝트 삭제
    public void deleteProject(Long id) {
        Project project = em.find(Project.class, id);
        if (project == null) {
            throw new IllegalStateException();
        }
        em.remove(project);
    }

    // 프로젝트 단건 조회
    public Project findProjectOne(Long id){
        return em.find(Project.class,id);
    }
}
