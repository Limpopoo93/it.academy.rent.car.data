package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> getRoleByUserId(Long userId);
}
