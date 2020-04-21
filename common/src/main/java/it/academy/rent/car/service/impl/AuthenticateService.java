package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.repository.AuthenticateRepository;
import it.academy.rent.car.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticateService{
    @Autowired
    private AuthenticateRepository authenticateRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Authenticate saveAuthenticate(Authenticate authenticate) {
        authenticate.setProfileRemote(true);
        authenticate.setProfileClose(true);
        authenticate.setPassword(bCryptPasswordEncoder.encode(authenticate.getPassword()));
        authenticateRepository.save(authenticate);
        return authenticate;
    }
    public Authenticate findByLoginAndPassword(String login, String password) {
        return authenticateRepository.findByLoginAndPassword(login, password);
    }
    public Authenticate findByLogin(String login) {
        return authenticateRepository.findByLogin(login);
    }

    @Transactional
    public Authenticate saveAndFlush(Authenticate authenticate) {
        return authenticateRepository.saveAndFlush(authenticate);
    }
    public List<Authenticate> findByProfileRemote(Boolean isDelete) {
        return authenticateRepository.findByProfileRemote(isDelete);
    }
    public Authenticate findById(Long id) {
        return authenticateRepository.findById(id).orElse(null);
    }

    public List<Authenticate> findByProfileClose(Boolean isDelete) {
        return authenticateRepository.findByProfileClose(isDelete);
    }

}
