package it.academy.rent.car.controller;

import it.academy.rent.car.bean.PriceCar;
import it.academy.rent.car.repository.PriceCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PriceCarController {
    @Autowired
    private PriceCarRepository priceCarRepository;

    @GetMapping("/createPrice")
    public String createByCar(PriceCar priceCar) {
        return "car/priceCarCreate";
    }

    @PostMapping("/createPrice")
    public String createCar(PriceCar priceCar) {
        priceCarRepository.save(priceCar);
        return "redirect:/createPrice";
    }
}
