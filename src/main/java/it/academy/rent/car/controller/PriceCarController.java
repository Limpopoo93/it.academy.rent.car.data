package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Car;
import it.academy.rent.car.bean.PriceCar;
import it.academy.rent.car.repository.CarRepository;
import it.academy.rent.car.repository.PriceCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PriceCarController {
    @Autowired
    private PriceCarRepository priceCarRepository;
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/createPrice")
    public String createByCar(PriceCar priceCar) {
        return "car/priceCarCreate";
    }

    @PostMapping("/createPrice")
    public String createCar(PriceCar priceCar) {
        priceCarRepository.save(priceCar);
        return "redirect:/createPrice";
    }

    @GetMapping("/updatePriceCar")
    public String updatePriceCar(Car car) {
        return "car/carSelectUpdatePrice";
    }

    @PostMapping("/updatePriceCar")
    public String updateSelectForm(Car car, Model model) {
        List<Car> cars = carRepository.findByNameCarAndMakeCarAndCompanyNameCompany(car.getNameCar(), car.getMakeCar(), car.getCompany().getNameCompany());
        model.addAttribute("cars", cars);
        return "car/carListUpdatePrice";
    }
    @GetMapping("/updateFormPrice/{id}")
    public String deleteLetter(@PathVariable("id") Long id, Model model) {
        PriceCar priceCar = priceCarRepository.findByIdPriceByCar(id);
        model.addAttribute("priceCar", priceCar);
        return "car/updatePriceCar";
    }
    @PostMapping("/updatePrice")
    public String updatePrice(PriceCar priceCar) {
     // я хз как сделать этот update т.к. в формы id нужен
        return "car/carListUpdatePrice";
    }
}
