package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Card;
import it.academy.rent.car.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    //создание кредитной карточки для оплаты
    @GetMapping("/createCreditCard")
    public String createCard(Card card) {
        return "card/createCreditCard";
    }

    @PostMapping("/createCreditCard")
    public String createCreditCard(Card card, HttpSession session) {
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
    public String deleteCardForm(Card card, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        if(card.getAuthenticate().getLogin().equals(authenticate.getLogin()) && card.getAuthenticate().getPassword().equals(authenticate.getPassword())){
            Card cardResult = cardRepository.findByNameUserAndKeyCardAndAuthenticateLoginAndAuthenticatePassword(card.getNameUser(), card.getKeyCard(),authenticate.getLogin(), authenticate.getPassword());
       cardRepository.delete(cardResult);
       return "cardDelete";
        }else {
            return "redirect:/cardDelete";
        }
    }
}
