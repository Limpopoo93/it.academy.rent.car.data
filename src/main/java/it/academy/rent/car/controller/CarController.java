package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Car;
import it.academy.rent.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/createCar")
    public String createByCar(Car car) {
        return "car/carCreate";
    }

    @PostMapping("/createCar")
    public String createCar(Car car) {
    carRepository.save(car);
        return "redirect:/createCar";
    }
}
