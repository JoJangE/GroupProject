package com.example.jojange.api;

import com.example.jojange.domain.Project;
import com.example.jojange.dto.ProjectDto;
import com.example.jojange.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // 프로젝트 생성
    @PostMapping("/api/group")
    @ResponseBody
    public Project createProjectController(@RequestBody ProjectDto request) {
        return projectService.createProject(request.getProjectName(), request.getProjectImg(),
                                            request.getStartDate(), request.getEndDate());
    }

    // 프로젝트 삭제
    @DeleteMapping("/api/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        // 200코드를 리턴
        return  new ResponseEntity(HttpStatus.OK);
    }

    // 프로젝트 조회
    @GetMapping("/api/{id}")
    public Project findProjectOne(@PathVariable Long id){
        return projectService.findProjectOne(id);
    }


}
