package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.repository.AuthenticateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class AuthenticateController {
    @Autowired
    private AuthenticateRepository authenticateRepository;
    @GetMapping("/")
    public String startPage(Map<String, Object> model) {
        return "main";
    }
    @GetMapping("/user-create")
    public String createUserForm(Authenticate authenticate) {
        return "index";
    }
    @PostMapping("/user-create")
    public String createUser(Authenticate authenticate, Model model) {
        authenticate.setProfileEnable(true);
        authenticate.setProfileClose(true);
        authenticate.setRole("user");
        authenticateRepository.save(authenticate);
        model.addAttribute(authenticate);
        return "redirect:/";
    }
}
