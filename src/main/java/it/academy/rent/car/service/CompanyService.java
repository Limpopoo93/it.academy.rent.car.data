package it.academy.rent.car.service;

import it.academy.rent.car.bean.Company;

import java.util.List;

public interface CompanyService {
    Company findByNameCompany(String nameCompany);

    Company save(Company company);

    Company findByIdAndAuthenticate(Long id);

    List<Company> findAll();

    Company findById(Long id);

    Company findByNameCompanyAndEmail(String company, String email);

    Company saveAndFlush(Company company);

}
