package com.example.demo1.services;


import com.example.demo1.domain.Project;
import com.example.demo1.repositories.ProjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepositories projectRepositories;


    public Project SaveOrUpdateProject(Project project){
        //logic


        return projectRepositories.save(project);
    }

}
