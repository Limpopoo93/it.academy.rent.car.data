package it.academy.rent.car.controller;

import it.academy.rent.car.bean.*;
import it.academy.rent.car.service.impl.AuthenticateService;
import it.academy.rent.car.service.impl.BusyDateServiceImpl;
import it.academy.rent.car.service.impl.CarServiceImpl;
import it.academy.rent.car.service.impl.LetterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;
import static it.academy.rent.car.util.InitConstant.ID;
import static it.academy.rent.car.util.PageConstant.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private LetterServiceImpl letterService;
    @Autowired
    private AuthenticateService authenticateService;
    @Autowired
    private CarServiceImpl carService;
    @Autowired
    private BusyDateServiceImpl busyDateService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/pushLetter")
    public String saveLetterByAdmin(@Valid Letter letter, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return LETTER_ADMIN;
        }
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        letter.setAuthenticate(authenticate);
        //не работает сохранение письма, проверить почему
        letterService.save(letter);
        return REDIRECT_MAIN;
    }

    @GetMapping("/userUpdate")
    public String updateUser(Authenticate authenticate, HttpSession session) {
        return USER_UPDATE;
    }

    @PostMapping("/userUpdate")
    public String updateUserByForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, CarSearch carSearch) {
        if (bindingResult.hasErrors()) {
            return USER_UPDATE;
        }
        Authenticate authenticateSession = (Authenticate) session.getAttribute(AUTHENTICATE);
        if (authenticate.getLogin() != null) {
            authenticateSession.setLogin(authenticate.getLogin());
        }
        if (authenticate.getPassword() != null) {
            authenticateSession.setPassword(bCryptPasswordEncoder.encode(authenticate.getPassword()));
        }
        if (authenticate.getEmail() != null) {
            authenticateSession.setEmail(authenticate.getEmail());
        }
        authenticateService.saveAndFlush(authenticateSession);
        session.setAttribute(AUTHENTICATE, authenticate);
        return "index";
    }

    @PostMapping("/searchFormCountry")
    public String carFindAll(@Valid CarSearch carSearch, BindingResult bindingResult, HttpSession session, Model model) {

        model.addAttribute("cars", carService.list(carSearch));
        session.setAttribute("carSearch", carSearch);
        return "car/carSearchList";
    }

    @GetMapping("/bookCarId/{id}")
    public String carByBook(@PathVariable(ID) Long id, HttpSession session, Model model) {
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

    @GetMapping("/listBookCar")
    public String carFindAllByUser(HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        List<BusyDate> busyDateList = busyDateService.findByAuthenticateIdAndBusyDateRemote(authenticate.getId(), true);
        model.addAttribute("busyDateList", busyDateList);
        return "car/carBasketUser";
    }

    @GetMapping("/userDeleteCheck/{id}")
    public String unBookByCarByUser(@PathVariable(ID) Long id) {
        BusyDate busyDate = busyDateService.findById(id);
        busyDate.setBusyDateRemote(false);
        busyDateService.saveAndFlush(busyDate);
        return "redirect:/user/listBookCar";
    }

    @GetMapping("/userDeleteByUser")
    public String deleteUser(Authenticate authenticate) {
        return USER_DELETE_USER;
    }

    @PostMapping("/userDeleteByUser")
    public String deleteUser(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Letter letter, CarSearch carSearch, Model model) {
        if (bindingResult.hasErrors()) {
            return USER_DELETE_USER;
        }
        Authenticate authenticateResult = authenticateService.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            model.addAttribute("authenticateError", "user empty");
            return REDIRECT_USER_COME;
        }
        Authenticate authenticateSession = (Authenticate) session.getAttribute(AUTHENTICATE);
        if (authenticateResult.getLogin().equals(authenticateSession.getLogin()) && authenticateResult.getPassword().equals(authenticateSession.getPassword()) && authenticateResult.getEmail().equals(authenticateSession.getEmail())) {
            Authenticate authenticateBase = authenticateService.findByLoginAndPassword(authenticateResult.getLogin(), authenticateResult.getPassword());
            authenticateBase.setProfileRemote(false);
            authenticateService.saveAndFlush(authenticateBase);
            session.invalidate();
            return INDEX;
        } else {
            model.addAttribute("authenticateError", "user dont deleted");
            return REDIRECT_USER_DELETE_USER;
        }
    }
}
