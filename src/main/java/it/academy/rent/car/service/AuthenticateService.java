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


}
