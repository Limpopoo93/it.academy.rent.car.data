package it.academy.rent.car.controller;

import it.academy.rent.car.bean.*;
import it.academy.rent.car.repository.BusyDateRepository;
import it.academy.rent.car.repository.CarRepository;
import it.academy.rent.car.repository.CompanyRepository;
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
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Controller
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private BusyDateRepository busyDateRepository;
    @Autowired
    private CompanyRepository companyRepository;

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
    public String createCar(@Valid Car car) {
        Company company = companyRepository.findByNameCompany(car.getCompany().getNameCompany());
        if(company != null){
            car.setCompany(company);
            carRepository.save(car);
        }
        return "redirect:/createCar";
    }

    //методы для поиска машины
    @PostMapping("/searchFormCountry")
    public String searchCar(@Valid CarSearch carSearch, HttpSession session, Model model) {
        List<Car> cars = carRepository.findByTownByAndByCountry(carSearch.getTown(), carSearch.getCountry());
        for (Car car:cars) {
            Long price = car.getPrice();
            Date dateCheck = carSearch.getDateCheck();
            Date dateReturn = carSearch.getDateReturn();
            int colDay = daysBetween(dateCheck, dateReturn);
            Long finalPrice = price*colDay;
            car.setPrice(finalPrice);
        }
        model.addAttribute("cars", cars);
        session.setAttribute("carSearch", carSearch);
        return "car/carSearchList";
    }
    public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    @GetMapping("/bookCarId/{id}")
    public String searchBookCar(@PathVariable("id") Long id, HttpSession session) {
        Car carResult = carRepository.findByCId(id);
        CarSearch carSearch = (CarSearch) session.getAttribute("carSearch");
        List<BusyDate> busyDateResult = busyDateRepository.findByBusyDate(carSearch.getDateCheck(), carSearch.getDateReturn());
        if (busyDateResult.isEmpty()) {
            Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
            BusyDate busyDate = new BusyDate();
            busyDate.setDateCheck(carSearch.getDateCheck());
            busyDate.setDateReturn(carSearch.getDateReturn());
            busyDate.setAuthenticate(authenticate);
            busyDate.setCar(carResult);
            busyDateRepository.save(busyDate);
            //тут ошибка при сохранении, скорей всего с датами что то не то, формат даты настроить
            return "redirect:/searchFormCountry";
        }
        //тут значит дата занята и надо вывести что дата заняти
        return "redirect:/searchFormCountry";
    }
    @GetMapping("/listCar")
    public String listCar(HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        Company company = companyRepository.findByIdAndAuthenticate(authenticate.getId());
        if (company.getAuthenticate().getId() != null){
            List<Car> cars = carRepository.findByIdCompany(company.getId(), true);
            model.addAttribute("cars", cars);
            return "car/carList";
        }else {
            List<Car> cars = carRepository.findAll();
            model.addAttribute("cars", cars);
            return "car/carList";
        }
    }


    @GetMapping("/carDeleteId/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        Car car = carRepository.findByCId(id);
        car.setCarRemote(false);
        carRepository.saveAndFlush(car);
        return "redirect:/listCar";
    }

}


