package com.portfolio.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService {

    @Autowired
    private ProjectsRepository projectsRepository;

    public void saveProject(Projects project) {
        projectsRepository.saveProject(project);
    }

    public Projects getProject(Long id) {
        return projectsRepository.getProjectById(id);
    }

    public void deleteProject(Long id) {
        projectsRepository.deleteProjectById(id);
    }

    public void updateProject(Projects project) {
        projectsRepository.updateProject(project);
    }

    public Iterable<Projects> getAllProjects() {
        return projectsRepository.getAllProjects();
    }
}
