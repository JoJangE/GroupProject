package com.example.jojange.service;

import com.example.jojange.domain.Project;
import com.example.jojange.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Project createProject(String projectName, String projectImg, LocalDateTime startDate, LocalDateTime endDate) {
        return projectRepository.createProject(projectName, projectImg, startDate, endDate);
    }

    @Transactional
    public void deleteProject(Long id) {
        projectRepository.deleteProject(id);
    }

    public Project findProjectOne(Long id){
        return projectRepository.findProjectOne(id);
    }
}