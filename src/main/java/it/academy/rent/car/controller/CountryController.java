package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Country;
import it.academy.rent.car.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

import static it.academy.rent.car.util.InitConstant.ID;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    //создание страны
    @GetMapping("admin/countryRegistration")
    public String createByCountry(Country country) {
        return "country/countryCreate";
    }

    @PostMapping("admin/countryRegistration")
    public String createCountry(@Valid Country country, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "country/countryCreate";
        }
        country.setCountryRemote(true);
        countryService.save(country);
        return "redirect:/countryRegistration";
    }

    @GetMapping("admin/listCountry")
    public String listCountry(Model model) {
        List<Country> countries = countryService.findByDelete(true);
        model.addAttribute("countries", countries);
        return "country/countryList";
    }

    @GetMapping("admin/countryDelete/{id}")
    public String listCountry(@PathVariable(ID) Long id) {
        Country countryResult = countryService.findById(id);
        countryResult.setCountryRemote(false);
        countryService.saveAndFlush(countryResult);
        return "redirect:/listCountry";
    }
}
