package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Letter;
import it.academy.rent.car.bean.Role;
import it.academy.rent.car.bean.User;
import it.academy.rent.car.repository.AuthenticateRepository;
import it.academy.rent.car.repository.LetterRepository;
import it.academy.rent.car.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String startPage(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/user-comeIn")
    public String comeInUser(Authenticate authenticate) {
        return "comeIn";
    }

    @PostMapping("/user-comeIn")
    public String comeInUser(Authenticate authenticate, HttpSession session) {
        Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult != null) {
            if (authenticateResult.isProfileEnable() == true) {
                authenticateResult.setProfileEnable(true);
                session.setAttribute("authenticate", authenticateResult);
                return "index";
            } else {
                return "letterAdmin";
            }
        }
        return "redirect:/user-comeIn";
    }

    @GetMapping("/user-create")
    public String createUser(Authenticate authenticate) {
        return "registrationAuthenticate";
    }

    @PostMapping("/user-create")
    public String createUser(Authenticate authenticate, HttpSession session) {
        Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setProfileEnable(true);
            authenticate.setProfileClose(true);
            authenticate.setRole(Role.USER);
            authenticateRepository.save(authenticate);
            session.setAttribute("authenticate", authenticate);
            return "index";
        }
        return "redirect:/user-create";
    }

    @GetMapping("/user-create-admin")
    public String createUserAdmin(Authenticate authenticate) {
        return "registrationAuthenticateAdmin";
    }

    @PostMapping("/user-create-admin")
    public String createUserAdmin(Authenticate authenticate, HttpSession session) {
        Authenticate authenticateResult = authenticateRepository.findByLoginAndPassword(authenticate.getLogin(), authenticate.getPassword());
        if (authenticateResult == null) {
            authenticate.setProfileEnable(true);
            authenticate.setProfileClose(true);
            authenticate.setRole(Role.ADMIN);
            authenticateRepository.save(authenticate);
            session.setAttribute("authenticate", authenticate);
            return "index";
        }
        return "redirect:/user-create";
    }

    @PostMapping("/add-letter")
    public String addLetterAdmin(Letter letter, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        letter.setAuthenticate(authenticate);
        letterRepository.save(letter);
        return "redirect:/";
    }

    @GetMapping("/user-logout")
    public String userLogout(HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        authenticate.setProfileEnable(false);
        session.invalidate();
        return "main";
    }
    @GetMapping("/users")
    public String findAll(Model model) {
        List<Authenticate> authenticates = authenticateRepository.findAll();
        model.addAttribute("authenticates", authenticates);
        return "/userList";
    }
    @GetMapping("user-updateId/{id}")
    public String updateUserAdmin(@PathVariable("id") Long id, Model model) {
        Authenticate authenticate = authenticateRepository.findByLId(id);
        model.addAttribute("authenticate", authenticate);
        return "/userUpdate";
    }
    @PostMapping("/user-update-form")
    public String updateUserForm(Authenticate authenticate) {
        Authenticate authenticateResult = authenticateRepository.findByLId(authenticate.getId());
        authenticateResult.setLogin(authenticate.getLogin());
        authenticateResult.setPassword(authenticate.getPassword());
        authenticateResult.setProfileEnable(authenticate.isProfileEnable());
        authenticateResult.setProfileClose(authenticate.isProfileClose());
        authenticateResult.setEmail(authenticate.getEmail());
        authenticateResult.setRole(authenticate.getRole());
        authenticateRepository.saveAndFlush(authenticateResult);
        return "redirect:/users";
    }
    @GetMapping("/user-deleteId/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        Authenticate authenticate = authenticateRepository.findByLId(id);
        authenticateRepository.delete(authenticate);
        return "redirect:/users";
    }
    @GetMapping("/user-blockId/{id}")
    public String findBlockUser(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateRepository.findByLId(id);
        authenticate.setProfileClose(false);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/users";
    }
    @GetMapping("user-unBlockId/{id}")
    public String userUnBlockId(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateRepository.findByLId(id);
        authenticate.setProfileClose(true);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/users";
    }
    @GetMapping("/letterAdminList")
    public String letterAdmin(Model model) {
        List<Letter> letters = letterRepository.findAll();
        model.addAttribute("letters", letters);
        return "/letterListUser";
    }
    @GetMapping("user-unBlockId/{id}")
    public String userUnBlockId(@PathVariable("id") Long id, Model model) {
        Authenticate authenticate = authenticateRepository.findByLId(id);
        authenticate.setProfileClose(true);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/letterAdminList";
    }
    @GetMapping("user-deleteLetter/{id}")
    public String userDeleteLetter(@PathVariable("id") Long id, Model model) {
        Letter letter = letterRepository.findByLId(id);
        letterRepository.delete(letter);
        return "redirect:/letterAdminList";
    }














    @GetMapping("/ban-user")
    public String banByUser(User user) {
        return "user/userBlock";
    }
    // бан аккаунта
    @PostMapping("/ban-user")
    public String banUser(Authenticate authenticate) {
        Authenticate authenticateResult = authenticateRepository.findByLId(authenticate.getId());
        authenticate.setProfileClose(false);
        authenticateRepository.saveAndFlush(authenticateResult);
        return "redirect:/ban-user";
    }
    //переход на разблакировку юзера
    @GetMapping("/unBan-user")
    public String unBanByUser(Authenticate authenticate) {
        return "user/userUnBlock";
    }
    // разблакировка юзера
    @PostMapping("/unBan-user")
    public String unBanUser(Authenticate authenticate) {
        Authenticate authenticateResult = authenticateRepository.findByLId(authenticate.getId());
        authenticateResult.setProfileClose(true);
        authenticateRepository.saveAndFlush(authenticateResult);
        return "redirect:/unBan-user";
    }
    // переход на страницу для поиска юзера для админа
    @GetMapping("/select-user")
    public String selectUser(Authenticate authenticate) {
        return "user/userFormSelect";
    }
    //лист писем от юзеров
    //удаления юзера из блокировки
    @GetMapping("user-deleteBanUser/{id}")
    public String deleteBanUser(@PathVariable("id") Long id, Letter letter, Model model) {
        Authenticate authenticate = authenticateRepository.findByLId(letter.getAuthenticate().getId());
        authenticate.setProfileClose(true);
        authenticateRepository.saveAndFlush(authenticate);
        List<Letter> letters = letterRepository.findAll();
        model.addAttribute("letters", letters);
        return "user/userFormSelect";
    }
    // вывод найденого юзера на страницу
    @PostMapping("/user-select")
    public String select(Authenticate authenticate, Model model) {
        if (authenticate.getUser().getName() != null && authenticate.getUser().getSurname() != null && authenticate.getLogin() != null) {
            User user = userRepository.findByNameAndSurname(authenticate.getUser().getName(), authenticate.getUser().getSurname());
            Authenticate authenticate1 = authenticateRepository.findByLogin(authenticate.getLogin());
            if(authenticate1.getUser().getId() == user.getId()){
                model.addAttribute("authenticate1", authenticate1);
                return "user/userSelectResult";
            }
        }
        return "user/userFormSelect";
    }
    //лист блокированных пользователей
    //удаление юзера из найденого юзера после поиска
    @GetMapping("user-deleteId/{id}")
    public String deleteUser(@PathVariable("id") Long id, Authenticate authenticate) {
        Authenticate authenticate1 = authenticateRepository.findByLId(id);
        authenticateRepository.deleteById(authenticate1.getId());
        userRepository.deleteById(authenticate1.getUser().getId());
        return "redirect:/users";
    }
    // перенаправление из формы юзера для изменения информации
    // блокировка юзера из формы поиска юзера
    // разблакировка юзера из формы юзера

    @GetMapping("/user-updateUser")
    public String updateUserForm(Model model, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        //User user = userService.findById(id);
        model.addAttribute("authenticate", authenticate);
        return "user/userUpdate";
    }
    //изменение информации о юзере
    @PostMapping("/user-update")
    public String updateUser(Model model,Authenticate authenticate) {
        Authenticate authenticate1 = authenticateRepository.findByLId(authenticate.getId());
        authenticate.setLogin(authenticate1.getLogin());
        authenticate.setPassword(authenticate1.getPassword());
        authenticate.setEmail(authenticate1.getEmail());
        authenticate.setProfileEnable(authenticate1.isProfileEnable());
        authenticate.setProfileClose(authenticate1.isProfileClose());
        authenticate.getUser().setName(authenticate1.getUser().getName());
        authenticate.getUser().setSurname(authenticate1.getUser().getSurname());
        authenticate.getUser().setAge(authenticate1.getUser().getAge());
        authenticateRepository.saveAndFlush(authenticate);
        model.addAttribute("authenticate", authenticate);
        return "index";
    }
}
