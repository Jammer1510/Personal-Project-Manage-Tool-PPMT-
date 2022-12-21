package com.example.demo1.services;


import com.example.demo1.domain.Project;
import com.example.demo1.exceptions.ProjectIDException;
import com.example.demo1.repositories.ProjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepositories projectRepositories;
    public Project SaveOrUpdateProject(Project project){
        //logic
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepositories.save(project);
        }catch(Exception e){
            throw new ProjectIDException("Project ID'"+project.getProjectIdentifier().toUpperCase()+"'already exists");
        }
    }

    public Project findbyProjectByIdentifer(String projectId){

        Project project = projectRepositories.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null){
            throw new ProjectIDException("Project ID'"+projectId+"'doesn't exists");
        }


        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepositories.findAll();
    }
    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepositories.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIDException("Cannot Project with ID'"+projectId+"'.This proct does not exist");
        }
        projectRepositories.delete(project);
    }
}
