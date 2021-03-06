package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.CarSearch;
import it.academy.rent.car.bean.Letter;
import it.academy.rent.car.bean.Role;
import it.academy.rent.car.exeption.EntityNotFoundException;
import it.academy.rent.car.service.impl.AuthenticateService;
import it.academy.rent.car.service.impl.RoleServiceImpl;
import it.academy.rent.car.service.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static it.academy.rent.car.util.ErrorConstant.*;
import static it.academy.rent.car.util.InitConstant.*;
import static it.academy.rent.car.util.PageConstant.*;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticateService authenticateService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleServiceImpl roleService;
    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping("/")
    public String main(Model model) {
        return MAIN;
    }

    @GetMapping("/userRegistration")
    public String saveUser(Authenticate authenticate) {
        return USER_REGISTRATION;
    }

    @PostMapping("/userRegistration")
    public String saveUserByForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return USER_REGISTRATION;
        }
        if (!authenticate.getPassword().equals(authenticate.getPasswordConfirm())) {
           throw new EntityNotFoundException(PASSWORD_ERROR);
        }
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setProfileRemote(true);
            authenticate.setProfileClose(true);
            authenticate.setPassword(authenticate.getPassword());
            authenticateService.saveAuthenticate(authenticate);
            roleService.save(new Role(authenticate.getId(), ROLE_USER));
            session.setAttribute(AUTHENTICATE, authenticate);
            return INDEX;
        }
        throw new EntityNotFoundException(USER_BUSY);
    }

    @GetMapping("/index")
    public String index(HttpSession session, CarSearch carSearch, Model model) {
        return INDEX;
    }

    @GetMapping("/userComeIn")
    public String comeInUser(Authenticate authenticate) {
        return USER_COME;
    }

    @PostMapping("/userComeIn")
    public String comeInUserByForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Letter letter, CarSearch carSearch, Model model) {
        UserDetails authenticateDetails = userDetailsService.loadUserByUsername(authenticate.getLogin());
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticateDetails.getUsername(), authenticateDetails.getPassword());
        if(authenticate.getLogin().equals(authenticateResult.getLogin()) && bCryptPasswordEncoder.matches(authenticate.getPassword(), authenticateResult.getPassword())){
            if (authenticateResult.getProfileRemote().equals(true)) {
                session.setAttribute(AUTHENTICATE_DETAILS, authenticateDetails);
                session.setAttribute(AUTHENTICATE, authenticateResult);
                if (authenticateResult.isProfileClose()) {
                    return INDEX;
                } else {
                    return LETTER_ADMIN;
                }
            }
        }
        throw new EntityNotFoundException(USER_EMPTY);
    }

}
