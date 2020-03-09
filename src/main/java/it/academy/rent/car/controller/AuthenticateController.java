package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Letter;
import it.academy.rent.car.bean.Role;
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

    @GetMapping("/user-info")
    public String createInfoUser(User user) {
        return "createUserInfo";
    }

    @PostMapping("/user-create-info")
    public String createUserInfo(User user) {
            userRepository.save(user);
            return "redirect:/index";
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
   // @GetMapping("user-unBlockId/{id}")
   // public String userUnBlockId(@PathVariable("id") Long id) {
   //     Authenticate authenticate = authenticateRepository.findByLId(id);
   //     authenticate.setProfileClose(true);
   //     authenticateRepository.saveAndFlush(authenticate);
    //    return "redirect:/users";
   // }
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
    @GetMapping("/user-ban-list")
    public String userBanList(Model model) {
        List<Authenticate> authenticates = authenticateRepository.findByProfileClose(false);
        model.addAttribute("authenticates", authenticates);
        return "/userBlockList";
    }
    @GetMapping("user-unBlock/{id}")
    public String userUnBlock(@PathVariable("id") Long id, Model model) {
        Authenticate authenticate = authenticateRepository.findByLId(id);
        authenticate.setProfileClose(true);
        authenticateRepository.saveAndFlush(authenticate);
        return "redirect:/user-ban-list";
    }
    @GetMapping("/update-userSession")
    public String selectUser(HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        model.addAttribute(authenticate);
        return "user/userUpdate";
    }
}
