package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.CarSearch;
import it.academy.rent.car.bean.Letter;
import it.academy.rent.car.bean.Role;
import it.academy.rent.car.service.AuthenticateService;
import it.academy.rent.car.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static it.academy.rent.car.util.InitConstant.*;
import static it.academy.rent.car.util.PageConstant.INDEX;
import static it.academy.rent.car.util.PageConstant.*;

@Controller
public class AuthenticateController {
    @Autowired
    private LetterService letterService;
    @Autowired
    private AuthenticateService authenticateService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String startPage(Map<String, Object> model) {
        return MAIN;
    }

    @GetMapping("user/userRegistration")
    public String createUser(Authenticate authenticate) {
        return USER_REGISTRATION;
    }

    @PostMapping("user/userRegistration")
    public String createUser(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return USER_REGISTRATION;
        }
        if (!authenticate.getPassword().equals(authenticate.getPasswordConfirm())) {
            model.addAttribute("passwordError", "password dont match");
            return USER_REGISTRATION;
        }
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
            authenticateService.saveAuthenticate(authenticate);
            session.setAttribute(AUTHENTICATE, authenticate);
            return INDEX;
        }
        model.addAttribute("authenticateError", "user busy");
        return REDIRECT_REGISTRATION;
    }

    @GetMapping("company/companyRegistration")
    public String createCompany(Authenticate authenticate) {
        return COMPANY_USER_REGISTRATION;
    }

    @PostMapping("company/companyRegistration")
    public String createCompanyUser(@Valid Authenticate authenticate, BindingResult bindingResult, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return COMPANY_USER_REGISTRATION;
        }
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setRoles(Collections.singleton(new Role(1L, "ROLE_COMPANY")));
            authenticateService.saveAuthenticate(authenticate);
            return INDEX;
        }
        model.addAttribute("companyError", "company busy");
        return REDIRECT_COMPANY_REGISTRATION;
    }

    @GetMapping("/userComeIn")
    public String comeInUser(Authenticate authenticate) {
        return USER_COME;
    }

    @PostMapping("/userComeIn")
    public String comeInUser(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Letter letter, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return USER_COME;
        }
        Authenticate authenticateResult = authenticateService.findByLogin(authenticate.getLogin());
        if (authenticateResult.getLogin().equals(authenticate.getLogin()) && bCryptPasswordEncoder.matches(authenticate.getPassword(), authenticateResult.getPassword())) {
            if (authenticateResult.getProfileRemote().equals(true)) {
                session.setAttribute(AUTHENTICATE, authenticateResult);
                if (authenticateResult.isProfileClose()) {
                    return INDEX;
                } else {
                    return LETTER_ADMIN;
                }
            }
            model.addAttribute("authenticateError", "user deleted");
            return REDIRECT_USER_COME;
        }
        model.addAttribute("authenticateError", "user dont registration");
        return REDIRECT_USER_COME;
    }

    @GetMapping("user/userDelete")
    public String deleteUser(Authenticate authenticate) {
        return USER_DELETE;
    }

    //ЭТО УДАЛЕНИЕ ТОЛЬКО ДЛЯ АДМИНА, НЕОБХОДИМО СДЕЛАТЬ УДАЛЕНИЕ ДЛЯ ЮЗЕРА КОТОРЫЙ В СЕССИИ ДЛЯ ОБЫЧНЫХ ПОЛЬЗОВАТЕЛЕЙ
    @PostMapping("user/userDelete")
    public String deleteUserForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Letter letter, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return USER_DELETE;
        }
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            model.addAttribute("authenticateError", "user empty");
            return REDIRECT_USER_COME;
        }
        Authenticate authenticateSession = (Authenticate) session.getAttribute(AUTHENTICATE);
        if (authenticateResult.getLogin().equals(authenticateSession.getLogin()) && authenticateResult.getPassword().equals(authenticateSession.getPassword()) && authenticateResult.getEmail().equals(authenticateSession.getEmail())) {
            model.addAttribute("authenticateError", "user dont deleted");
            return REDIRECT_USER_DELETE;
        } else {
            Authenticate authenticateBase = authenticateService.findByLoginAndPassword(authenticateResult.getLogin(), authenticateResult.getPassword());
            authenticateBase.setProfileRemote(false);
            authenticateService.saveAndFlush(authenticateBase);
            session.invalidate();
            return INDEX;
        }
    }

    @PostMapping("user/pushLetter")
    public String addLetterAdmin(@Valid Letter letter, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return LETTER_ADMIN;
        }
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        letter.setAuthenticate(authenticate);
        //не работает сохранение письма, проверить почему
        letterService.save(letter);
        return REDIRECT_MAIN;
    }

    @GetMapping("admin/adminCreate")
    public String createAdmin(Authenticate authenticate) {
        return ADMIN_REGISTRATION;
    }

    @PostMapping("admin/adminCreate")
    public String createAdminBase(@Valid Authenticate authenticate, BindingResult bindingResult, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return ADMIN_REGISTRATION;
        }
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setRoles(Collections.singleton(new Role(1L, "ROLE_ADMIN")));
            authenticateService.saveAuthenticate(authenticate);
            return INDEX;
        }
        model.addAttribute("authenticateError", "user empty");
        return REDIRECT_ADMIN_CREATE;
    }

    @GetMapping("admin/users")
    public String findAll(Model model) {
        List<Authenticate> authenticates = authenticateService.findByDelete(true);
        model.addAttribute(AUTHENTICATIES, authenticates);
        return USER_LIST;
    }

    @GetMapping("admin/userDeleteId/{id}")
    public String deleteUser(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileRemote(false);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_USER_LIST;
    }

    @GetMapping("admin/userBlockId/{id}")
    public String findBlockUser(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileClose(false);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_USER_LIST;
    }

    @GetMapping("admin/userUnBlockId/{id}")
    public String userUnBlockId(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileClose(true);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_USER_LIST;
    }

    @GetMapping("admin/letterAdminList")
    public String letterAdmin(Model model, BindingResult bindingResult) {
        List<Letter> letters = letterService.findByLetterList(true);
        model.addAttribute(LETTERS, letters);
        return LETTER_LIST;
    }

    @GetMapping("admin/userUnBlockLetterId/{id}")
    public String userLetterUnblock(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileClose(true);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_LETTER_LIST;
    }

    @GetMapping("admin/deleteLetter/{id}")
    public String deleteLetter(@PathVariable(ID) Long id) {
        Letter letter = letterService.findById(id);
        letter.setLetterRemote(false);
        letterService.saveAndFlush(letter);
        return REDIRECT_LETTER_LIST;
    }

    @GetMapping("admin/userBlockList")
    public String userBanList(Model model) {
        List<Authenticate> authenticate = authenticateService.findByProfileClose(false);
        model.addAttribute(AUTHENTICATE, authenticate);
        return USER_BLOCK_LIST;
    }

    @GetMapping("admin/userBlock/{id}")
    public String userBlockList(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileClose(true);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_USER_BLOCK_LIST;
    }

    @GetMapping("user/userUpdate")
    public String updateUser(Authenticate authenticate, HttpSession session) {
        return USER_UPDATE;
    }

    @PostMapping("user/userUpdate")
    public String updateUserForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return USER_UPDATE;
        }
        Authenticate authenticateSession = (Authenticate) session.getAttribute(AUTHENTICATE);
        Authenticate authenticateResult = authenticateService.findById(authenticateSession.getId());
        authenticateResult.setLogin(authenticate.getLogin());
        authenticateResult.setPassword(authenticate.getPassword());
        authenticateResult.setEmail(authenticate.getEmail());
        authenticateService.saveAndFlush(authenticateResult);
        session.invalidate();
        session.setAttribute(AUTHENTICATE, authenticateResult);
        return REDIRECT_USER_UPDATE;
    }
}
