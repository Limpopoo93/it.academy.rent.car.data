package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CardRepository extends JpaRepository<Card, Long> {

    Card findByNameUserAndKeyCardAndAuthenticateLoginAndAuthenticatePassword(String nameUser, Long keyCard, String authenticate_login, String authenticate_password);
}
