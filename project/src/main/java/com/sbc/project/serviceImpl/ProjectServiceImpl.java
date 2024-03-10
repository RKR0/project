package com.sbc.project.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbc.project.dto.ProjectDto;
import com.sbc.project.exception.ProjectNotFoundException;
import com.sbc.project.model.Project;
import com.sbc.project.repository.ProjectRepo;
import com.sbc.project.service.ProjectService;
import com.sbc.project.transformer.ProjectTransformer;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	
	@Autowired
	ProjectRepo projectRepo;

	@Override
	public ProjectDto registerNewProject(ProjectDto projectDto) {
		
		Project project = ProjectTransformer.ProjectDtoToProject(projectDto);
		
		// save Project to database
		Project ans = projectRepo.save(project);
		
		// Transfer ProjectDto to Project
		ProjectDto updateProjectDto = ProjectTransformer.ProjectToProjectDto(ans);
			
		return updateProjectDto;
	}

	@Override
	public String deleteProject(Integer projectId) {
		
		Optional<Project> project= projectRepo.findById(projectId);
		
		if(project.isEmpty())
			throw new ProjectNotFoundException("Invalid Project Id!!");
		
		return "Project Deleted Sucessfully";
	}

	@Override
	public ProjectDto updateProject(ProjectDto project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDto getprojectById(Integer projectId) {
		
		Optional<Project> project= projectRepo.findById(projectId);
		
		if(project.isEmpty())
			throw new ProjectNotFoundException("Invalid Project Id!!");
		
		return  ProjectTransformer.ProjectToProjectDto(project.get());
		
	}

	@Override
	public List<ProjectDto> getAllProjects() {
		
		List<Project> project= projectRepo.findAll();
		
		List<ProjectDto> projectDto = new ArrayList<>();
		for(Project p:project) {
			projectDto.add(ProjectTransformer.ProjectToProjectDto(p));
		}
		
		return projectDto;
	}

}
