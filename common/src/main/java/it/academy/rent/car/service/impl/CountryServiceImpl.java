package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Country;
import it.academy.rent.car.repository.CountryRepository;
import it.academy.rent.car.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> findByCountryRemote(Boolean isDelete) {
        return countryRepository.findByCountryRemote(isDelete);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Country saveAndFlush(Country country) {
        return countryRepository.saveAndFlush(country);
    }

    @Override
    public Country findByNameCountry(String country) {
        return countryRepository.findByNameCountry(country);
    }
}
