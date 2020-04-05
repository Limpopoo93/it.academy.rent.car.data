package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Company;
import it.academy.rent.car.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/createCompany")
    public String createByCompany(Company company) {
        return "company/companyRegistration";
    }

    @PostMapping("/createCompany")
    public String createCompany(@Valid Company company, HttpSession session) {
        // приходит норм request но я не вижу города. решить проблему надо
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        company.setReting(0L);
        company.setAuthenticate(authenticate);
        companyRepository.save(company);
        return "redirect:/createCompany";
    }
    @GetMapping("/listCompany")
    public String listCompany(Model model) {
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies",companies);
        return "company/companyList";
    }

    @GetMapping("listCompanyForm/{id}")
    public String listCompany(@PathVariable("id") Long id) {
        Company company = companyRepository.findByLId(id);
        companyRepository.delete(company);
        return "redirect:/listCompany";
    }
    @GetMapping("/deleteCompany")
    public String deleteCompany(Company company) {
        return "company/deleteCompany";
    }
    @PostMapping("/deleteCompany")
    public String deleteCompanyForm(@Valid Company company, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
       if(company.getAuthenticate().getLogin().equals(authenticate.getLogin()) && company.getAuthenticate().getPassword().equals(authenticate.getPassword())){
           Company companyResult = companyRepository.findByNameCompanyAndEmail(company.getNameCompany(), company.getEmail());
           if(companyResult!= null){
                companyResult.setCompanyRemote(false);
                companyRepository.saveAndFlush(companyResult);
           }
       }else {
           return "redirect:/deleteCompany";
       }
        return "redirect:/deleteCompany";
    }
}
