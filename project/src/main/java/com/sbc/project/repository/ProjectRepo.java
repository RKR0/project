package com.sbc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbc.project.model.Project;


@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer>{

}
