package com.example.jojange.Controller;


import com.example.jojange.domain.Project;
import com.example.jojange.dto.ProjectDto;
import com.example.jojange.dto.ProjectResponseDto;
import com.example.jojange.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ProjectApiController {

    private final ProjectService projectService;

    @PostMapping("/api/project")
    public Project CreateProject(@RequestBody ProjectDto projectDto){
        return projectService.createProject(projectDto.getProjectName(),projectDto.getProjectImg(),projectDto.getLink(),
                projectDto.getStartDate(),projectDto.getEndDate());
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);

        // 200코드를 리턴
        return  new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/{id}")
    public Project findProjectOne(@PathVariable Long id){
        return projectService.findProjectOne(id);
    }



}
