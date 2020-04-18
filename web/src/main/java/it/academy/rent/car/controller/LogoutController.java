package it.academy.rent.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static it.academy.rent.car.util.PageConstant.MAIN;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    public String logout(HttpSession session) {
        session.invalidate();
        return MAIN;
    }
}
