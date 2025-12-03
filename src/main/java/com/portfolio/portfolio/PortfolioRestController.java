package com.portfolio.portfolio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioRestController {
    
    private final UsersService usersService;
    private final ProjectsService projectsService;

    public PortfolioRestController(UsersService usersService, ProjectsService projectsService) {
        this.usersService = usersService;
        this.projectsService = projectsService;
    }

    @GetMapping("/grab_user/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Users user = usersService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/grab_projects")
    public ResponseEntity<Iterable<Projects>> getAllProjects() {
        Iterable<Projects> projects = projectsService.getAllProjects();
        return ResponseEntity.ok(projects);
    }
}
