package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
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
    public String createUser(Authenticate authenticate, HttpSession session) {
        Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setProfileClose(true);
            authenticate.setRole(Role.USER);
            authenticateRepository.save(authenticate);
            session.setAttribute("authenticate", authenticate);
            return "index";
        }
        return "redirect:/userRegistration";
    }
 //переход с main на страницу входа
 @GetMapping("/userComeIn")
 public String comeInUser(Authenticate authenticate) {
     return "user/comeIn";
 }
 //переход со страницы входа проверка и отправка на index при открытом доступе7
 @PostMapping("/userComeIn")
 public String comeInUser(Authenticate authenticate, HttpSession session) {
     Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
     if (authenticateResult != null) {
         if (authenticateResult.isProfileClose() == true) {
             session.setAttribute("authenticate", authenticateResult);
             return "index";
         } else {
             return "user/letterAdmin";
         }
     }
     return "redirect:/userComeIn";
 }
//переход со страницы письмо админу, добавление базу и отправка на main
@PostMapping("/pushLetter")
public String addLetterAdmin(Letter letter, HttpSession session) {
    Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
    letter.setAuthenticate(authenticate);
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
public String createAdminBase(Authenticate authenticate) {
    Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
    if (authenticateResult == null) {
        authenticate.setProfileClose(true);
        authenticate.setRole(Role.ADMIN);
        authenticateRepository.save(authenticate);
        return "index";
    }
    return "redirect:/adminCreate";
}
//лист всех юзеров для админа
@GetMapping("/users")
public String findAll(Model model) {
    List<Authenticate> authenticates = authenticateRepository.findAll();
    model.addAttribute("authenticates", authenticates);
    return "user/userList";
}
//удаление юзера из таблицы всех пользователей
@GetMapping("/userDeleteId/{id}")
public String deleteUser(@PathVariable("id") Long id){
    Authenticate authenticate = authenticateRepository.findByLId(id);
    authenticateRepository.delete(authenticate);
    return "redirect:/users";
}
//блокировка пользователя из таблицы юзера
@GetMapping("/userBlockId/{id}")
public String findBlockUser(@PathVariable("id") Long id) {
    Authenticate authenticate = authenticateRepository.findByLId(id);
    authenticate.setProfileClose(false);
    authenticateRepository.saveAndFlush(authenticate);
    return "redirect:/users";
}
//разблокировка пользователя из таблицы юзера
    @GetMapping("userUnBlockId/{id}")
    public String userUnBlockId(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateRepository.findByLId(id);
        authenticate.setProfileClose(true);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/users";
    }
//переход на страницу со списком писем заблокированых пользователей
@GetMapping("/letterAdminList")
public String letterAdmin(Model model) {
    List<Letter> letters = letterRepository.findAll();
    model.addAttribute("letters", letters);
    return "user/letterList";
}
//разблакировка юзера со страницы списка писем
@GetMapping("userUnBlockLetterId/{id}")
public String userLetterUnblock(@PathVariable("id") Long id) {
    Authenticate authenticate = authenticateRepository.findByLId(id);
    authenticate.setProfileClose(true);
    authenticateRepository.saveAndFlush(authenticate);
    return "redirect:/letterAdminList";
}
//удалить письмо из страницы списка писем
@GetMapping("/deleteLetter/{id}")
public String deleteLetter(@PathVariable("id") Long id){
    Letter letter = letterRepository.findByLId(id);
    letterRepository.delete(letter);
    return "redirect:/letterAdminList";
}
//список блокированных юзеров
@GetMapping("/userBlockList")
public String userBanList(Model model) {
    List<Authenticate> authenticates = authenticateRepository.findByProfileClose(false);
    model.addAttribute("authenticates", authenticates);
    return "user/userBlockList";
}
//разблакировка юзера и переход на страницу лист блок юзера
@GetMapping("userBlock/{id}")
public String userBlockList(@PathVariable("id") Long id) {
    Authenticate authenticate = authenticateRepository.findByLId(id);
    authenticate.setProfileClose(true);
    authenticateRepository.saveAndFlush(authenticate);
    return "redirect:/userBlockList";
}

}
