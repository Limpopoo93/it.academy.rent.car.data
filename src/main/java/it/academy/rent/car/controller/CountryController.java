package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Country;
import it.academy.rent.car.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    //создание страны
    @GetMapping("/countryRegistration")
    public String createByCountry(Country country) {
        return "country/countryCreate";
    }
    @PostMapping("/countryRegistration")
    public String createCountry(Country country) {
        countryRepository.save(country);
        return "redirect:/countryRegistration";
    }

}
