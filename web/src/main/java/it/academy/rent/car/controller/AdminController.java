package it.academy.rent.car.controller;

import it.academy.rent.car.bean.*;
import it.academy.rent.car.exeption.EntityNotFoundException;
import it.academy.rent.car.service.impl.AuthenticateService;
import it.academy.rent.car.service.impl.CompanyServiceImpl;
import it.academy.rent.car.service.impl.LetterServiceImpl;
import it.academy.rent.car.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import static it.academy.rent.car.util.ErrorConstant.LOGIN_PASSWORD_NOT_WALID;
import static it.academy.rent.car.util.ErrorConstant.USER_EMPTY;
import static it.academy.rent.car.util.InitConstant.*;
import static it.academy.rent.car.util.PageConstant.INDEX;
import static it.academy.rent.car.util.PageConstant.*;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final LetterServiceImpl letterService;
    private final AuthenticateService authenticateService;
    private final CompanyServiceImpl companyService;
    private final RoleServiceImpl roleService;

    @GetMapping("/userDelete")
    public String deleteUser(Authenticate authenticate) {
        return USER_DELETE;
    }

    @PostMapping("/userDelete")
    public String deleteUser(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Letter letter, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return USER_DELETE;
        }
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            throw new EntityNotFoundException(USER_EMPTY);
        }
        Authenticate authenticateSession = (Authenticate) session.getAttribute(AUTHENTICATE);
        if (authenticateResult.getLogin().equals(authenticateSession.getLogin()) && authenticateResult.getPassword().equals(authenticateSession.getPassword()) && authenticateResult.getEmail().equals(authenticateSession.getEmail())) {
            throw new EntityNotFoundException(LOGIN_PASSWORD_NOT_WALID);
        } else {
            Authenticate authenticateBase = authenticateService.findByLoginAndPassword(authenticateResult.getLogin(), authenticateResult.getPassword());
            authenticateBase.setProfileRemote(false);
            authenticateService.saveAndFlush(authenticateBase);
            session.invalidate();
            return INDEX;
        }
    }

    @GetMapping("/adminRegistration")
    public String saveAdmin(Authenticate authenticate) {
        return ADMIN_REGISTRATION;
    }

    @PostMapping("/adminRegistration")
    public String saveAdminForm(@Valid Authenticate authenticate, BindingResult bindingResult, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return ADMIN_REGISTRATION;
        }
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticateService.saveAuthenticate(authenticate);
            roleService.save(new Role(authenticate.getId(), ROLE_ADMIN));
            return INDEX;
        }
        throw new EntityNotFoundException(USER_EMPTY);
    }

    @GetMapping("/users")
    public String findAllByUsers(Model model) {
        List<Authenticate> authenticates = authenticateService.findByProfileRemote(true);
        model.addAttribute(AUTHENTICATIES, authenticates);
        return USER_LIST;
    }

    @GetMapping("/userDeleteId/{id}")
    public String deleteUser(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileRemote(false);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_USER_LIST;
    }

    @GetMapping("/userBlockId/{id}")
    public String blockUserAccount(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileClose(false);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_USER_LIST;
    }

    @GetMapping("/userUnBlockId/{id}")
    public String unblockUserAccount(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileClose(true);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_USER_LIST;
    }

    @GetMapping("/letterAdminList")
    public String findAllByLetters(Model model, Letter letter) {
        List<Letter> letters = letterService.findByLetterRemote(true);
        model.addAttribute(LETTERS, letters);
        return LETTER_LIST;
    }

    @GetMapping("/userUnBlockLetterId/{id}")
    public String unblockUserByListLetter(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileClose(true);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_LETTER_LIST;
    }

    @GetMapping("/deleteLetter/{id}")
    public String deleteByLetter(@PathVariable(ID) Long id) {
        Letter letter = letterService.findById(id);
        letter.setLetterRemote(false);
        letterService.saveAndFlush(letter);
        return REDIRECT_LETTER_LIST;
    }

    @GetMapping("/userBlockList")
    public String userDeleteByList(Model model) {
        List<Authenticate> authenticate = authenticateService.findByProfileClose(false);
        model.addAttribute(AUTHENTICATE, authenticate);
        return USER_BLOCK_LIST;
    }

    @GetMapping("/userBlock/{id}")
    public String userBlockList(@PathVariable(ID) Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setProfileClose(true);
        authenticateService.saveAndFlush(authenticate);
        return REDIRECT_USER_BLOCK_LIST;
    }

    @GetMapping("/listCompany")
    public String listAllByCompany(Model model) {
        List<Company> companies = companyService.findAll();
        model.addAttribute(COMPANYS, companies);
        return COMPANY_LIST;
    }

    @GetMapping("/listCompanyForm/{id}")
    public String deleteCompanyByList(@PathVariable(ID) Long id) {
        Company company = companyService.findById(id);
        company.setCompanyRemote(false);
        companyService.saveAndFlush(company);
        return REDIRECT_COMPANY_LIST;
    }

    @GetMapping("/deleteCompany")
    public String deleteCompany(Company company) {
        return DELETE_COMPANY;
    }

    @PostMapping("/deleteCompany")
    public String deleteCompany(@Valid Company company, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return DELETE_COMPANY;
        }
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        if (company.getAuthenticate().getLogin().equals(authenticate.getLogin()) && company.getAuthenticate().getPassword().equals(authenticate.getPassword())) {
            Company companyResult = companyService.findByNameCompanyAndEmail(company.getNameCompany(), company.getEmail());
            if (companyResult != null) {
                companyResult.setCompanyRemote(false);
                companyService.saveAndFlush(companyResult);
                return REDIRECT_DELETE_COMPANY;
            }
        }
        throw new EntityNotFoundException(USER_EMPTY);
    }
}
