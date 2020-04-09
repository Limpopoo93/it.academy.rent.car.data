package it.academy.rent.car.service;

import it.academy.rent.car.bean.Card;
import it.academy.rent.car.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public Card findByNameUserAndKeyCardAndAuthenticateLoginAndAuthenticatePassword(String nameUser, Long keyCard, String login, String password) {
        return cardRepository.findByNameUserAndKeyCardAndAuthenticateLoginAndAuthenticatePassword(nameUser, keyCard, login, password);
    }

    public Card saveAndFlush(Card card) {
        return cardRepository.saveAndFlush(card);
    }
}
