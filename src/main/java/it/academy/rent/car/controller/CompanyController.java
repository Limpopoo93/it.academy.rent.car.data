package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.CarSearch;
import it.academy.rent.car.bean.Company;
import it.academy.rent.car.bean.Role;
import it.academy.rent.car.service.impl.AuthenticateService;
import it.academy.rent.car.service.impl.CompanyServiceImpl;
import it.academy.rent.car.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;
import static it.academy.rent.car.util.PageConstant.*;

@Controller
@RequiredArgsConstructor
public class CompanyController {
    private final AuthenticateService authenticateService;
    private final CompanyServiceImpl companyService;
    private final RoleServiceImpl roleService;

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
            roleService.save(new Role(authenticate.getId(), "ROLE_COMPANY"));
            return INDEX;
        }
        model.addAttribute("companyError", "company busy");
        return REDIRECT_COMPANY_REGISTRATION;
    }

    @GetMapping("/createCompany")
    public String createByCompany(Company company) {
        return "company/companyRegistration";
    }

    @PostMapping("/createCompany")
    public String saveCompany(@Valid Company company, BindingResult bindingResult, HttpSession session) {
        // приходит норм request но я не вижу города. решить проблему надо
        if (bindingResult.hasErrors()) {
            return "user/userUpdateInfo";
        }
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        company.setReting(0L);
        company.setAuthenticate(authenticate);
        companyService.save(company);
        return "redirect:/createCompany";
    }
}
