package it.academy.rent.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "select user from user  where name = ? and surname = ?")
    User findByNameAndSurname(String name, String surname);
}
