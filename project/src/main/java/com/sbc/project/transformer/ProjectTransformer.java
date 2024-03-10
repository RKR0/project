package com.sbc.project.transformer;

import com.sbc.project.dto.ProjectDto;
import com.sbc.project.model.Project;

public class ProjectTransformer {

	public static Project ProjectDtoToProject(ProjectDto projectDto) {
		// TODO Auto-generated method stub
		return Project.builder()
				.name(projectDto.getName())
				.description(projectDto.getDescription())
				.startDate(projectDto.getStartDate())
				.endDate(projectDto.getEndDate())
				.build();
	}
	
	
	public static ProjectDto ProjectToProjectDto(Project project) {
		// TODO Auto-generated method stub
		return ProjectDto.builder()
				.id(project.getId())
				.name(project.getName())
				.description(project.getDescription())
				.startDate(project.getStartDate())
				.endDate(project.getEndDate())
				.build();
	}

}
