package it.academy.rent.car.service;

import it.academy.rent.car.bean.Authenticate;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AuthenticateService {
    List<Authenticate> findByProfileClose(Boolean isDelete);

    List<Authenticate> findByProfileRemote(Boolean isDelete);

    Authenticate saveAndFlush(Authenticate authenticate);

    Authenticate findByLogin(String login);

    Authenticate findByLoginAndPassword(String login, String password);

    Authenticate saveAuthenticate(Authenticate authenticate);

    UserDetails loadUserByUsername(String login);

    Authenticate findById(Long id);
}
