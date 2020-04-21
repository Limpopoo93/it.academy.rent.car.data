package it.academy.rent.car.service;

import it.academy.rent.car.bean.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);
    Role getOneRoleByUserId(Long userId);
    List<Role> getRoleByUserId(Long userId);

}
