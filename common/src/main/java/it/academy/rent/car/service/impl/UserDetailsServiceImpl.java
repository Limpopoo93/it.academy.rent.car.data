package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Authenticate;
import it.academy.rent.car.bean.Role;
import it.academy.rent.car.repository.AuthenticateRepository;
import it.academy.rent.car.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticateRepository authenticateRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Authenticate authenticate = authenticateRepository.findByLogin(login);
        List<Role> roles = roleRepository.getRoleByUserId(authenticate.getId());


        if (authenticate == null) {
            throw new UsernameNotFoundException("User not found");
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                authenticate.getLogin(),
                authenticate.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(roles.get(0).getRoleName())
        );
        return userDetails;
    }
}
