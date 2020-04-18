package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Country;
import it.academy.rent.car.service.impl.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

import static it.academy.rent.car.util.InitConstant.COUNTRYS;
import static it.academy.rent.car.util.InitConstant.ID;
import static it.academy.rent.car.util.PageConstant.*;

@Controller
@RequiredArgsConstructor
public class CountryController {
    @Autowired
    private CountryServiceImpl countryService;

    //создание страны
    @GetMapping("/countryRegistration")
    public String saveCountry(Country country) {
        return COUNTRY_CREATE;
    }

    @PostMapping("/countryRegistration")
    public String saveCountry(@Valid Country country, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return COUNTRY_CREATE;
        }
        country.setCountryRemote(true);
        countryService.save(country);
        return REDIRECT_COUNTRY_CREATE;
    }

    @GetMapping("/listCountry")
    public String listAllByCountry(Model model) {
        List<Country> countries = countryService.findByCountryRemote(true);
        model.addAttribute(COUNTRYS, countries);
        return COUNTRY_LIST;
    }

    @GetMapping("/countryDelete/{id}")
    public String findByCountry(@PathVariable(ID) Long id) {
        Country countryResult = countryService.findById(id);
        countryResult.setCountryRemote(false);
        countryService.saveAndFlush(countryResult);
        return "redirect:/listCountry";
    }
}
