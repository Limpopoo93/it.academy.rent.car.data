package it.academy.rent.car.controller;

import it.academy.rent.car.bean.*;
import it.academy.rent.car.service.BusyDateService;
import it.academy.rent.car.service.CarService;
import it.academy.rent.car.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;
import static it.academy.rent.car.util.InitConstant.ID;


@Controller
public class CarController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private BusyDateService busyDateService;
    @Autowired
    private CarService carService;

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("company/createCar")
    public String createByCar(Car car) {
        return "car/carCreate";
    }

    @PostMapping("company/createCar")
    public String createCar(@Valid Car car, BindingResult bindingResult, Model model) {
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
    @PostMapping("user/searchFormCountry")
    public String searchCar(@Valid CarSearch carSearch, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "car/carSearchTown";
        }
        model.addAttribute("cars", carService.list(carSearch));
        session.setAttribute("carSearch", carSearch);
        return "car/carSearchList";
    }


    @GetMapping("/bookCarId/{id}")
    public String searchBookCar(@PathVariable(ID) Long id, HttpSession session, Model model) {
        Car carResult = carService.findById(id);
        CarSearch carSearch = (CarSearch) session.getAttribute("carSearch");
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        List<BusyDate> busyDateResult = busyDateService.findByBusyDate(carSearch.getDateCheck(), carSearch.getDateReturn());
        if (busyDateResult.isEmpty()) {
            BusyDate busyDate = new BusyDate();
            busyDate.setDateCheck(carSearch.getDateCheck());
            busyDate.setDateReturn(carSearch.getDateReturn());
            busyDate.setAuthenticate(authenticate);
            busyDate.setCar(carResult);
            busyDate.setBusyDateRemote(true);
            Long colDay = carService.daysBetween(carSearch.getDateCheck(), carSearch.getDateReturn());
            Long price = carResult.getPrice();
            Long finalPrice = price * colDay;
            busyDate.setPriceCar(finalPrice);
            busyDateService.save(busyDate);
            return "redirect:/searchFormCountry";
        }
        model.addAttribute("carError", "date busy");
        return "car/carSearchTown";
    }

    @GetMapping("company/listCar")
    public String listCar(HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        Company company = companyService.findByIdAndAuthenticate(authenticate.getId());
        if (company.getAuthenticate().getId() != null) {
            List<Car> cars = carService.findByIdCompany(company.getId(), true);
            model.addAttribute("cars", cars);
            return "car/carList";
        } else {
            List<Car> cars = carService.findAll();
            model.addAttribute("cars", cars);
            return "car/carList";
        }
    }


    @GetMapping("company/carDeleteId/{id}")
    public String deleteCar(@PathVariable(ID) Long id) {
        Car car = carService.findById(id);
        car.setCarRemote(false);
        carService.saveAndFlush(car);
        return "redirect:/listCar";
    }

    @GetMapping("user/listBookCar")
    public String listBookCar(HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        List<BusyDate> busyDateList = busyDateService.findByAuthenticateIdAndBusyDateRemote(authenticate.getId(), true);
        model.addAttribute("busyDateList", busyDateList);
        return "car/carBasketUser";
    }

    @GetMapping("user/userDeleteCheck/{id}")
    public String basketCarUser(@PathVariable(ID) Long id) {
        BusyDate busyDate = busyDateService.findById(id);
        busyDate.setBusyDateRemote(false);
        busyDateService.saveAndFlush(busyDate);
        return "redirect:/user/listBookCar";
    }
}


