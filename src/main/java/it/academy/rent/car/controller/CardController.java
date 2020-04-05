package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Card;
import it.academy.rent.car.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //создание кредитной карточки для оплаты
    @GetMapping("/createCreditCard")
    public String createCard(Card card) {
        return "card/createCreditCard";
    }

    @PostMapping("/createCreditCard")
    public String createCreditCard(@Valid Card card, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        card.setAuthenticate(authenticate);
        cardRepository.save(card);
        return "redirect:/createCreditCard";
    }
    @GetMapping("/cardDelete")
    public String deleteCard(Card card) {
        return "card/createCreditCard";
    }

    @PostMapping("/cardDelete")
    public String deleteCardForm(@Valid Card card, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        if(card.getAuthenticate().getLogin().equals(authenticate.getLogin()) && card.getAuthenticate().getPassword().equals(authenticate.getPassword())){
            Card cardResult = cardRepository.findByNameUserAndKeyCardAndAuthenticateLoginAndAuthenticatePassword(card.getNameUser(), card.getKeyCard(),authenticate.getLogin(), authenticate.getPassword());
        cardResult.setCardRemote(false);
        cardRepository.saveAndFlush(cardResult);
       return "cardDelete";
        }else {
            return "redirect:/cardDelete";
        }
    }
}
