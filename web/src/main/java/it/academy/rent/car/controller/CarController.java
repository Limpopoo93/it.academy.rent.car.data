package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Car;
import it.academy.rent.car.bean.Company;
import it.academy.rent.car.exeption.EntityNotFoundException;
import it.academy.rent.car.service.impl.BusyDateServiceImpl;
import it.academy.rent.car.service.impl.CarServiceImpl;
import it.academy.rent.car.service.impl.CompanyServiceImpl;
import lombok.RequiredArgsConstructor;
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

import static it.academy.rent.car.util.ErrorConstant.USER_EMPTY;
import static it.academy.rent.car.util.InitConstant.*;
import static it.academy.rent.car.util.PageConstant.*;


@Controller
@RequiredArgsConstructor
public class CarController {
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private BusyDateServiceImpl busyDateService;
    @Autowired
    private CarServiceImpl carService;

    @GetMapping("/createCar")
    public String saveCar(Car car) {
        return CAR_CREATE;
    }

    @PostMapping("/createCar")
    public String saveCar(@Valid Car car, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return USER_UPDATE;
        }
        Company company = companyService.findByNameCompany(car.getCompany().getNameCompany());
        if (company != null) {
            car.setCompany(company);
            carService.save(car);
            return REDIRECT_CREATE_CAR;
        }
        throw new EntityNotFoundException(USER_EMPTY);
    }

    @GetMapping("/listCar")
    public String carFindAllByCompany(HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        Company company = companyService.findByIdAndAuthenticate(authenticate.getId());
        if (company == null) {
            List<Car> cars = new ArrayList<>();
            model.addAttribute(CARS, cars);
        } else {
            List<Car> cars = carService.findByIdCompany(company.getId(), true);
            model.addAttribute(CARS, cars);
        }
        return CAR_LIST;
    }

    @GetMapping("/carDeleteId/{id}")
    public String deleteCar(@PathVariable(ID) Long id) {
        Car car = carService.findById(id);
        car.setCarRemote(false);
        carService.saveAndFlush(car);
        return REDIRECT_LIST_CAR;
    }

}


