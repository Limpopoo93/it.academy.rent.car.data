package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Role;
import it.academy.rent.car.repository.RoleRepository;
import it.academy.rent.car.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getRoleByUserId(Long userId) {
        return roleRepository.getRoleByUserId(userId);
    }

    @Override
    public Role getOneRoleByUserId(Long userId) {
        return roleRepository.getOneRoleByUserId(userId);
    }
}
