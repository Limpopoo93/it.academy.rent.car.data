package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.CarSearch;
import it.academy.rent.car.bean.Letter;
import it.academy.rent.car.bean.Role;
import it.academy.rent.car.repository.AuthenticateRepository;
import it.academy.rent.car.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AuthenticateController {
    @Autowired
    private AuthenticateRepository authenticateRepository;
    @Autowired
    private LetterRepository letterRepository;

    //для перехода на стартовую страницу
    @GetMapping("/")
    public String startPage(Map<String, Object> model) {
        return "main";
    }

    //переход с main на страницу регистрации
    @GetMapping("/userRegistration")
    public String createUser(Authenticate authenticate) {
        return "user/userRegistration";
    }

    //переход с регистрации на index и добавление нового юзера
    @PostMapping("/userRegistration")
    public String createUser(Authenticate authenticate, HttpSession session, CarSearch carSearch) {
        Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setProfileRemote(true);
            authenticate.setProfileClose(true);
            authenticate.setRole(Role.USER);
            authenticateRepository.save(authenticate);
            session.setAttribute("authenticate", authenticate);
            return "index";
        }
        return "redirect:/userRegistration";
    }

    //переход с main на страницу регистрации
    @GetMapping("/companyRegistration")
    public String createCompany(Authenticate authenticate) {
        return "company/companyRegistrationUser";
    }

    //переход с регистрации на index и добавление нового юзера
    @PostMapping("/companyRegistration")
    public String createCompanyUser(Authenticate authenticate, CarSearch carSearch) {
        Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setProfileRemote(true);
            authenticate.setProfileClose(true);
            authenticate.setRole(Role.COMPANY);
            authenticateRepository.save(authenticate);
            return "index";
        }
        return "redirect:/companyRegistration";
    }

    //переход с main на страницу входа
    @GetMapping("/userComeIn")
    public String comeInUser(Authenticate authenticate) {
        return "user/userComeIn";
    }

    //переход со страницы входа проверка и отправка на index при открытом доступе7
    @PostMapping("/userComeIn")
    public String comeInUser(Authenticate authenticate, HttpSession session, Letter letter, CarSearch carSearch) {
        Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult != null && authenticateResult.getProfileRemote().equals(true)) {
            session.setAttribute("authenticate", authenticateResult);
            if (authenticateResult.isProfileClose()) {
                return "index";
            } else {
                return "user/userLetterAdmin";
            }
        }
        return "redirect:/userComeIn";
    }
    //переход с main на страницу входа
    @GetMapping("/userDelete")
    public String deleteUser(Authenticate authenticate) {
        return "user/userDelete";
    }

    //ЭТО УДАЛЕНИЕ ТОЛЬКО ДЛЯ АДМИНА, НЕОБХОДИМО СДЕЛАТЬ УДАЛЕНИЕ ДЛЯ ЮЗЕРА КОТОРЫЙ В СЕССИИ ДЛЯ ОБЫЧНЫХ ПОЛЬЗОВАТЕЛЕЙ
    @PostMapping("/userDelete")
    public String deleteUserForm(Authenticate authenticate, HttpSession session, Letter letter, CarSearch carSearch) {
        Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        Authenticate authenticateSession = (Authenticate) session.getAttribute("authenticate");
        if(authenticateResult.getLogin().equals(authenticateSession.getLogin()) && authenticateResult.getPassword().equals(authenticateSession.getPassword()) && authenticateResult.getEmail().equals(authenticateSession.getEmail())){
            return "redirect:/userDelete";
        }else {
            Authenticate authenticateBase = authenticateRepository.findByLoginAndPassword(authenticateResult.getLogin(), authenticateResult.getPassword());
            authenticateBase.setProfileRemote(false);
            authenticateRepository.saveAndFlush(authenticateBase);
            session.invalidate();
            return "index";
        }
    }

    //переход со страницы письмо админу, добавление базу и отправка на main
    @PostMapping("/pushLetter")
    public String addLetterAdmin(Letter letter, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        letter.setAuthenticate(authenticate);
        //не работает сохранение письма, проверить почему
        letterRepository.save(letter);
        return "redirect:/";
    }

    //переход на страницу регистрации админа
    @GetMapping("/adminCreate")
    public String createAdmin(Authenticate authenticate) {
        return "user/adminRegistration";
    }

    //создания админа и переход на index
    @PostMapping("/adminCreate")
    public String createAdminBase(Authenticate authenticate,CarSearch carSearch) {
        Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setRole(Role.ADMIN);
            authenticate.setProfileClose(true);
            authenticate.setProfileRemote(true);
            authenticateRepository.save(authenticate);
            return "index";
        }
        return "redirect:/adminCreate";
    }

    //лист всех юзеров для админа
    @GetMapping("/users")
    public String findAll(Model model) {
        List<Authenticate> authenticates = authenticateRepository.findByDelete(true);
        model.addAttribute("authenticates", authenticates);
        return "user/userList";
    }

    //удаление юзера из таблицы всех пользователей
    @GetMapping("/userDeleteId/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateRepository.findByAId(id);
        authenticate.setProfileRemote(false);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/users";
    }

    //блокировка пользователя из таблицы юзера
    @GetMapping("/userBlockId/{id}")
    public String findBlockUser(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateRepository.findByAId(id);
        authenticate.setProfileClose(false);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/users";
    }

    //разблокировка пользователя из таблицы юзера
    @GetMapping("userUnBlockId/{id}")
    public String userUnBlockId(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateRepository.findByAId(id);
        authenticate.setProfileClose(true);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/users";
    }

    //переход на страницу со списком писем заблокированых пользователей
    @GetMapping("/letterAdminList")
    public String letterAdmin(Model model) {
       // List<Letter> letters = letterRepository.findByDelete();
        //model.addAttribute("letters", letters);
        return "user/letterList";
    }

    //разблакировка юзера со страницы списка писем
    @GetMapping("userUnBlockLetterId/{id}")
    public String userLetterUnblock(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateRepository.findByAId(id);
        authenticate.setProfileClose(true);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/letterAdminList";
    }

    //удалить письмо из страницы списка писем
    @GetMapping("/deleteLetter/{id}")
    public String deleteLetter(@PathVariable("id") Long id) {
        Letter letter = letterRepository.findByIdLetter(id);
        letter.setLetterRemote(false);
        letterRepository.saveAndFlush(letter);
        return "redirect:/letterAdminList";
    }

    //список блокированных юзеров
    @GetMapping("/userBlockList")
    public String userBanList(Model model) {
        List<Authenticate> authenticate = authenticateRepository.findByProfileClose(false);
        model.addAttribute("authenticate", authenticate);
        return "user/userBlockList";
    }

    //разблакировка юзера и переход на страницу лист блок юзера
    @GetMapping("userBlock/{id}")
    public String userBlockList(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateRepository.findByAId(id);
        authenticate.setProfileClose(true);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/userBlockList";
    }
    //переход на страницу регистрации админа
    @GetMapping("/userUpdate")
    public String updateUser(Authenticate authenticate, HttpSession session) {
        return "user/userUpdateInfo";
    }

    //создания админа и переход на index
    @PostMapping("/userUpdate")
    public String updateUserForm(Authenticate authenticate, HttpSession session) {
        Authenticate authenticateSession = (Authenticate) session.getAttribute("authenticate");
        Authenticate authenticateResult = authenticateRepository.findByAId(authenticateSession.getId());
        authenticateResult.setLogin(authenticate.getLogin());
        authenticateResult.setPassword(authenticate.getPassword());
        authenticateResult.setEmail(authenticate.getEmail());
        authenticateRepository.saveAndFlush(authenticateResult);
        session.invalidate();
        session.setAttribute("authenticate", authenticateResult);
        return "redirect:/userUpdate";
    }
}
