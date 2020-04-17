package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Company;
import it.academy.rent.car.repository.CompanyRepository;
import it.academy.rent.car.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company findByNameCompany(String nameCompany) {
        return companyRepository.findByNameCompany(nameCompany);
    }

    @Transactional
    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company findByIdAndAuthenticate(Long id) {
        return companyRepository.findByIdAndAuthenticate(id);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company findByNameCompanyAndEmail(String company, String email) {
        return companyRepository.findByNameCompanyAndEmail(company, email);
    }

    @Transactional
    @Override
    public Company saveAndFlush(Company company) {
        return companyRepository.saveAndFlush(company);
    }
}
