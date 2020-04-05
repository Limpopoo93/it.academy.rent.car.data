package it.academy.rent.car.service;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Role;
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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public Authenticate findUserById(Long userId) {
        Optional<Authenticate> userFromDb = authenticateRepository.findById(userId);
        return userFromDb.orElse(new Authenticate());
    }

    public List<Authenticate> allUsers() {
        return authenticateRepository.findAll();
    }

    public boolean saveUser(Authenticate authenticate) {
        Authenticate userFromDB = authenticateRepository.findByLogin(authenticate.getLogin());

        if (userFromDB != null) {
            return false;
        }

        authenticate.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        authenticate.setPassword(bCryptPasswordEncoder.encode(authenticate.getPassword()));
        authenticateRepository.save(authenticate);
        return true;
    }


}
