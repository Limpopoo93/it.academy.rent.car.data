package it.academy.rent.car.controller;

import it.academy.rent.car.bean.*;
import it.academy.rent.car.exeption.EntityNotFoundException;
import it.academy.rent.car.service.impl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static it.academy.rent.car.util.ErrorConstant.TOWN_COUNTRY;
import static it.academy.rent.car.util.ErrorConstant.USER_EMPTY;
import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;
import static it.academy.rent.car.util.InitConstant.ROLE_COMPANY;
import static it.academy.rent.car.util.PageConstant.*;

@Controller
@RequiredArgsConstructor
public class CompanyController {
    private final AuthenticateService authenticateService;
    private final CompanyServiceImpl companyService;
    private final RoleServiceImpl roleService;
    private final CountryServiceImpl countryService;
    private final TownServiceImpl townService;

    @GetMapping("/companyRegistration")
    public String saveUserByCompany(Authenticate authenticate) {
        return COMPANY_USER_REGISTRATION;
    }

    @PostMapping("/companyRegistration")
    public String saveUserByCompany(@Valid Authenticate authenticate, BindingResult bindingResult, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return COMPANY_USER_REGISTRATION;
        }
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticateService.saveAuthenticate(authenticate);
            roleService.save(new Role(authenticate.getId(), ROLE_COMPANY));
            return INDEX;
        }
        throw new EntityNotFoundException(USER_EMPTY);
    }

    @GetMapping("/createCompany")
    public String createByCompany(Company company) {
        return COMPANY_CREATE;
    }

    @PostMapping("/createCompany")
    public String saveCompany(@Valid Company company, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return USER_UPDATE;
        }
        Country country = countryService.findByNameCountry(company.getTown().getCountry().getNameCountry());
        if(country!= null){
            Town town = townService.findByTownAndCountry(company.getTown().getNameTown(), company.getTown().getCountry().getNameCountry());
            if(town != null){
                Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
                Authenticate authenticateResult = authenticateService.findByLogin(authenticate.getLogin());
                company.setReting(0L);
                company.setAuthenticate(authenticateResult);
                company.setTown(town);
                companyService.save(company);
                return REDIRECT_CREATE_COMPANY;
            }
        }
        throw new EntityNotFoundException(TOWN_COUNTRY);
    }
}
