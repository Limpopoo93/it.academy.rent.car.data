package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Country;
import it.academy.rent.car.bean.Town;
import it.academy.rent.car.repository.CountryRepository;
import it.academy.rent.car.repository.TownRepository;
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
public class TownController {
    @Autowired
    private TownRepository townRepository;
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("admin/createTown")
    public String createByTown(Town town) {
        return "town/townCreate";
    }

    @PostMapping("admin/createTown")
    public String createTown(@Valid Town town, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "town/townCreate";
        }
        Country country = countryRepository.findByNameCountry(town.getCountry().getNameCountry());
        town.setCountry(country);
        town.setTownRemote(true);
        townRepository.saveAndFlush(town);
        return "redirect:/createTown";
    }

    @GetMapping("admin/searchListTown")
    public String searchListTown(Country Country) {
        return "town/townSearchList";
    }

    @PostMapping("admin/listTown")
    public String listTown(Country country, Model model) {
        List<Town> towns = townRepository.findByCountry(country.getNameCountry(), true);
        model.addAttribute("towns", towns);
        return "town/townList";
    }

    @GetMapping("admin/townDelete/{id}")
    public String deleteTown(@PathVariable(ID) Long id) {
        Town town = townRepository.findById(id).orElse(null);
        town.setTownRemote(false);
        townRepository.saveAndFlush(town);
        return "redirect:/searchListTown";
    }
}
