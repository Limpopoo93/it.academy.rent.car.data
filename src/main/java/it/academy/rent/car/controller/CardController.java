package it.academy.rent.car.controller;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Card;
import it.academy.rent.car.bean.CategoryCard;
import it.academy.rent.car.bean.DriveCard;
import it.academy.rent.car.repository.CardRepository;
import it.academy.rent.car.repository.CategoryCardRepository;
import it.academy.rent.car.repository.DriveCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CardController {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private DriveCardRepository driveCardRepository;

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

    //создание водительских прав
    @GetMapping("/createDriveCard")
    public String createDriveCard(DriveCard driveCard) {
        return "card/createCreditCard";
    }

    @PostMapping("/createDriveCard")
    public String createDriveCard(DriveCard driveCard, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        driveCard.setAuthenticate(authenticate);
        driveCardRepository.save(driveCard);
        return "redirect:/createDriveCard";
    }

}
