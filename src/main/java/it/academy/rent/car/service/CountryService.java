package it.academy.rent.car.service;

import it.academy.rent.car.bean.Country;
import it.academy.rent.car.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public List<Country> findByDelete(Boolean isDelete) {
        return countryRepository.findByDelete(isDelete);
    }

    public Country findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public Country saveAndFlush(Country country) {
        return countryRepository.saveAndFlush(country);
    }

    public Country findByNameCountry(String country) {
        return countryRepository.findByNameCountry(country);
    }
}
