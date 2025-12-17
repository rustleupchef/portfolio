package com.portfolio.portfolio;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.password4j.Hash;
import com.password4j.Password;

import jakarta.servlet.http.HttpSession;

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
    public String signupPage(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/";
        }
        return "signup";
    }

    @PostMapping("/signup")
    @ResponseBody public ResponseMessage signup(@RequestBody SignRequest request, HttpSession session) {
        if (usersService.userExists(request.getUsername())) {
            return new ResponseMessage("error", "Username has already been used before");
        }

        Hash hash = Password.hash(request.getPassword()).withBcrypt();

        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setRole(false);
        user.setPassword(hash.getResult());

        usersService.createUser(user);
        session.setAttribute("user", user);
        return new ResponseMessage("success", "User has been created succesfully!");
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody public ResponseMessage login(@RequestBody SignRequest request, HttpSession session) {
        Users user = usersService.getUser(request.getUsername());

        if (user == null) {
            return new ResponseMessage("error", "user doesn't exist");
        }

        if (Password.check(request.getPassword(), user.getPassword()).withBcrypt()) {
            session.setAttribute("user", user);
            return new ResponseMessage("success", "LOGGED IN");
        }

        return new ResponseMessage("error", "invalid credentials");
    }
}
