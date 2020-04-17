package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Role;
import it.academy.rent.car.repository.AuthenticateRepository;
import it.academy.rent.car.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticateService implements UserDetailsService{
    @Autowired
    private AuthenticateRepository authenticateRepository;
    @Autowired
    private RoleRepository roleRepository;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Authenticate authenticate = authenticateRepository.findByLogin(login);
        List<Role> roles = roleRepository.getRoleByUserId(authenticate.getId());


        if (authenticate == null) {
            throw new UsernameNotFoundException("User not found");
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                authenticate.getLogin(),
                authenticate.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(roles.get(0).getRole())
        );
        return userDetails;
    }

    @Transactional
    public Authenticate saveAuthenticate(Authenticate authenticate) {
        authenticate.setProfileRemote(true);
        authenticate.setProfileClose(true);
        authenticate.setPassword(authenticate.getPassword());
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
