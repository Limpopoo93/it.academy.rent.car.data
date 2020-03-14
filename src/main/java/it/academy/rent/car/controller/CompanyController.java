package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Company;
import it.academy.rent.car.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/createCompany")
    public String createByCompany(Company company) {
        return "company/companyRegistration";
    }

    @PostMapping("/createCompany")
    public String createCompany(Company company) {
        company.setReting(0);
        companyRepository.save(company);
        return "redirect:/createCompany";
    }
}
