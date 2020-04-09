package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Card;
import it.academy.rent.car.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;

@Controller
public class CardController {
    @Autowired
    private CardService cardService;

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //создание кредитной карточки для оплаты
    @GetMapping("user/createCreditCard")
    public String createCard(Card card) {
        return "card/createCreditCard";
    }

    @PostMapping("user/createCreditCard")
    public String createCreditCard(@Valid Card card, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "user/userUpdateInfo";
        }
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        card.setAuthenticate(authenticate);
        cardService.save(card);
        return "redirect:/createCreditCard";
    }

    @GetMapping("user/cardDelete")
    public String deleteCard(Card card) {
        return "card/createCreditCard";
    }

    @PostMapping("user/cardDelete")
    public String deleteCardForm(@Valid Card card, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "card/createCreditCard";
        }
        Authenticate authenticate = (Authenticate) session.getAttribute(AUTHENTICATE);
        if (card.getAuthenticate().getLogin().equals(authenticate.getLogin()) && card.getAuthenticate().getPassword().equals(authenticate.getPassword())) {
            Card cardResult = cardService.findByNameUserAndKeyCardAndAuthenticateLoginAndAuthenticatePassword(card.getNameUser(), card.getKeyCard(), authenticate.getLogin(), authenticate.getPassword());
            cardResult.setCardRemote(false);
            cardService.saveAndFlush(cardResult);
            return "cardDelete";
        } else {
            return "redirect:/cardDelete";
        }
    }
}
