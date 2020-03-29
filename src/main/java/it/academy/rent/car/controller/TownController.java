package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Town;
import it.academy.rent.car.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TownController {
    @Autowired
    private TownRepository townRepository;

    @GetMapping("/createTown")
    public String createByTown(Town town) {
        return "town/townCreate";
    }

    @PostMapping("/createTown")
    public String createTown(Town town) {
        townRepository.save(town);
        return "redirect:/createTown";
    }
    @GetMapping("/searchListTown")
    public String searchListTown(Town town) {
        return "town/townSearchList";
    }

    @PostMapping("/listTown")
    public String listTown(Town town, Model model) {
        List<Town> towns = townRepository.findByCountry(town.getCountry());
        model.addAttribute("towns", towns);
        return "town/townList";
    }
    @GetMapping("/townDelete/{id}")
    public String deleteTown(@PathVariable("id") Long id) {
       Town town = townRepository.findByAId(id);
       townRepository.delete(town);
        return "redirect:/searchListTown";
    }
}
