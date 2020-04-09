package it.academy.rent.car.service;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.repository.AuthenticateRepository;
import it.academy.rent.car.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AuthenticateService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    AuthenticateRepository authenticateRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Authenticate authenticate = authenticateRepository.findByLogin(login);

        if (authenticate == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return authenticate;
    }

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

    public Authenticate saveAndFlush(Authenticate authenticate) {
        return authenticateRepository.saveAndFlush(authenticate);
    }

    public List<Authenticate> findByDelete(Boolean isDelete) {
        return authenticateRepository.findByDelete(isDelete);
    }

    public Authenticate findById(Long id) {
        return authenticateRepository.findById(id).orElse(null);
    }

    public List<Authenticate> findByProfileClose(Boolean isDelete) {
        return authenticateRepository.findByProfileClose(isDelete);
    }
}
