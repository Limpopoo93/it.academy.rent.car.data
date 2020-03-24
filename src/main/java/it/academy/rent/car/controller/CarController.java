package it.academy.rent.car.controller;

import it.academy.rent.car.bean.BusyDate;
import it.academy.rent.car.bean.Car;
import it.academy.rent.car.bean.CarSearch;
import it.academy.rent.car.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Controller
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private TownRepository townRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BusyDateRepository busyDateRepository;
    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @GetMapping("/createCar")
    public String createByCar(Car car) {
        return "car/carCreate";
    }

    @PostMapping("/createCar")
    public String createCar(Car car) {
        carRepository.save(car);
        return "redirect:/createCar";
    }

    //методы для поиска машины
    @PostMapping("/searchFormCountry")
    public String searchCar(CarSearch carSearch, HttpSession session, Model model) {
        List<Car> cars = carRepository.findByCar(carSearch.getTown(), carSearch.getCountry());
        model.addAttribute("cars", cars);
        session.setAttribute("carSearch", carSearch);
        return "car/carSearchList";
    }
    @GetMapping("/bookCarId/{id}")
    public String searchBookCar(@PathVariable("id") Long id, HttpSession session) {
       Car car = carRepository.getOne(id);
       CarSearch carSearch = (CarSearch) session.getAttribute("carSearch");
       List<BusyDate> busyDate =busyDateRepository.findByBusyDate(carSearch.getDateCheck(), carSearch.getDateReturn());
        return "car/carSearchList";
    }
}
