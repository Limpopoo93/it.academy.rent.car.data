package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Role;
import it.academy.rent.car.repository.RoleRepository;
import it.academy.rent.car.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
