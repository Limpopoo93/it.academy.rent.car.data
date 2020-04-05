package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Country;
import it.academy.rent.car.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

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
    public String createCountry(@Valid Country country) {
        country.setCountryRemote(true);
        countryRepository.save(country);
        return "redirect:/countryRegistration";
    }
    @GetMapping("/listCountry")
    public String listCountry(Model model) {
       List<Country> countries = countryRepository.findByDelete(true);
        model.addAttribute("countries",countries);
        return "country/countryList";
    }
    @GetMapping("/countryDelete/{id}")
    public String listCountry(@PathVariable("id") Long id) {
        Country countryResult = countryRepository.findByCId(id);
        countryResult.setCountryRemote(false);
        countryRepository.saveAndFlush(countryResult);
        return "redirect:/listCountry";
    }
}
