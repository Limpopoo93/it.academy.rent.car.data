package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Car;
import it.academy.rent.car.bean.Town;
import it.academy.rent.car.repository.CarRepository;
import it.academy.rent.car.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
