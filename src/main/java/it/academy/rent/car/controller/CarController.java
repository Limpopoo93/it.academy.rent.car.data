package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Car;
import it.academy.rent.car.bean.Company;
import it.academy.rent.car.service.BusyDateService;
import it.academy.rent.car.service.CarService;
import it.academy.rent.car.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;
import static it.academy.rent.car.util.InitConstant.ID;


@Controller
//@RequestMapping("/company")
public class CarController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private BusyDateService busyDateService;
    @Autowired
    private CarService carService;

    @GetMapping("/createCar")
    public String saveCar(Car car) {
        return "car/carCreate";
    }

    @PostMapping("/createCar")
    public String saveCar(@Valid Car car, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/userUpdateInfo";
        }
        Company company = companyService.findByNameCompany(car.getCompany().getNameCompany());
        if (company != null) {
            car.setCompany(company);
            carService.save(car);
        }
        model.addAttribute("carError", "company empty");
        return "redirect:/createCar";
    }

    //методы для поиска машины


    @GetMapping("/listCar")
    public String carFindAllByCompany(HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        Company company = companyService.findByIdAndAuthenticate(authenticate.getId());
        if(company == null){
            List<Car> cars = new ArrayList<>();
            model.addAttribute("cars", cars);
        }else {
            List<Car> cars = carService.findByIdCompany(company.getId(), true);
            model.addAttribute("cars", cars);
        }
            return "car/carList";
    }
    @GetMapping("/carDeleteId/{id}")
    public String deleteCar(@PathVariable(ID) Long id) {
        Car car = carService.findById(id);
        car.setCarRemote(false);
        carService.saveAndFlush(car);
        return "redirect:/listCar";
    }

}


