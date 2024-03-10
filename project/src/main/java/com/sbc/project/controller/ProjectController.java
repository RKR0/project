package com.sbc.project.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sbc.project.dto.ProjectDto;
import com.sbc.project.service.ProjectService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
      this.projectService = projectService;
  }
    
	// New Project register
	@PostMapping("/register")
	public ResponseEntity<ProjectDto> registerNewProject(@Valid @RequestBody ProjectDto projectDto){
			
			try {
				ProjectDto createprojectdto = projectService.registerNewProject(projectDto);
				return new ResponseEntity<ProjectDto>(createprojectdto, HttpStatus.CREATED);
				
			}
			catch(Exception e){
				return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}

	
	// Update Project 
	@PutMapping("/update")
	public ResponseEntity updateProject(@RequestBody ProjectDto projectDto){
		
		try {
			ProjectDto updateprojectdto = projectService.updateProject(projectDto);
			return new ResponseEntity(updateprojectdto,HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
}
	
	
	// get Project by projectId
	@GetMapping("/projectid/{projectid}")
	public ResponseEntity getprojectById(@PathVariable Integer projectid){
			
			try {
				ProjectDto project = projectService.getprojectById(projectid);
				return new ResponseEntity(project,HttpStatus.OK);
			}
			catch(Exception e){
				return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
}
		
	// get all Users
	@GetMapping("/")
	public ResponseEntity getAllProjects(){
					
		try {
			 List<ProjectDto> project = projectService.getAllProjects();
		 	return new ResponseEntity(project,HttpStatus.OK);
	    }
		catch(Exception e){
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
}
					
	// Delete Project by projectId
	@DeleteMapping("delete/projectid/{projectid}")
	public ResponseEntity deleteProject(@PathVariable Integer projectid){
					
		try {
			String project = projectService.deleteProject(projectid);
			return new ResponseEntity(project,HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
}
	
					
}
