package com.example.jojange.service;


import com.example.jojange.domain.Project;
import com.example.jojange.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    //project 저장
    public Project createProject(String projectName, String projectImg, String link, Date startDate, Date endDate){
        return projectRepository.createProject(projectName,projectImg,link,startDate,endDate);
    }

    @Transactional
    public void deleteProject(Long id){
        projectRepository.deleteProject(id);
    }

    @Transactional
    public Project findProjectOne(Long id){
        return projectRepository.findProjectOne(id);
    }

}
