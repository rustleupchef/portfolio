package com.portfolio.portfolio;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {
    
    private final UsersService usersService;
    private final ProjectsService projectsService;

    public PortfolioController(UsersService usersService, ProjectsService projectsService) {
        this.usersService = usersService;
        this.projectsService = projectsService;
    }

    @GetMapping("/grab_projects")
    public ResponseEntity<Iterable<Projects>> getAllProjects() {
        Iterable<Projects> projects = projectsService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/")
    public String indexPage() {
        return "redirect:/portfolio";
    }

    @GetMapping("/portfolio")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
