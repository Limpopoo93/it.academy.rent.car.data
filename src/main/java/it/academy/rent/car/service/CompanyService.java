package it.academy.rent.car.service;

import it.academy.rent.car.bean.Company;
import it.academy.rent.car.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company findByNameCompany(String nameCompany) {
        return companyRepository.findByNameCompany(nameCompany);
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company findByIdAndAuthenticate(Long id) {
        return companyRepository.findByIdAndAuthenticate(id);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }

    public Company findByNameCompanyAndEmail(String company, String email) {
        return companyRepository.findByNameCompanyAndEmail(company, email);
    }

    public Company saveAndFlush(Company company) {
        return companyRepository.saveAndFlush(company);
    }
}
