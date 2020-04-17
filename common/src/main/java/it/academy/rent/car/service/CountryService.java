package it.academy.rent.car.service;

import it.academy.rent.car.bean.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);

    List<Country> findByCountryRemote(Boolean isDelete);

    Country findById(Long id);

    Country saveAndFlush(Country country);

    Country findByNameCountry(String country);

}
