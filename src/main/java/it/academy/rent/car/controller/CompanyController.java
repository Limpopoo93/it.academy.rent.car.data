package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Company;
import it.academy.rent.car.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;
import static it.academy.rent.car.util.InitConstant.ID;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("company/createCompany")
    public String createByCompany(Company company) {
        return "company/companyRegistration";
    }

    @PostMapping("/createCompany")
    public String createCompany(@Valid Company company, BindingResult bindingResult, HttpSession session) {
        // приходит норм request но я не вижу города. решить проблему надо
        if (bindingResult.hasErrors()) {
            return "user/userUpdateInfo";
        }
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        company.setReting(0L);
        company.setAuthenticate(authenticate);
        companyRepository.save(company);
        return "redirect:/createCompany";
    }

    @GetMapping("admin/listCompany")
    public String listCompany(Model model) {
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        return "company/companyList";
    }

    @GetMapping("admin/listCompanyForm/{id}")
    public String listCompany(@PathVariable(ID) Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        companyRepository.delete(company);
        return "redirect:/listCompany";
    }

    @GetMapping("admin/deleteCompany")
    public String deleteCompany(Company company) {
        return "company/deleteCompany";
    }

    @PostMapping("admin/deleteCompany")
    public String deleteCompanyForm(@Valid Company company, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "company/deleteCompany";
        }
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        if (company.getAuthenticate().getLogin().equals(authenticate.getLogin()) && company.getAuthenticate().getPassword().equals(authenticate.getPassword())) {
            Company companyResult = companyRepository.findByNameCompanyAndEmail(company.getNameCompany(), company.getEmail());
            if (companyResult != null) {
                companyResult.setCompanyRemote(false);
                companyRepository.saveAndFlush(companyResult);
            }
        } else {
            return "redirect:/deleteCompany";
        }
        return "redirect:/deleteCompany";
    }
}
