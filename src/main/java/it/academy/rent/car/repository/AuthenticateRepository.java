package it.academy.rent.car.repository;
import it.academy.rent.car.bean.Authenticate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AuthenticateRepository extends JpaRepository<Authenticate, Long> {
    @Query("select a from Authenticate a where a.login = :login and a.password = :password")
    Authenticate findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
    @Query("select a from Authenticate a where a.profileClose = :profileclose")
    List<Authenticate> findByProfileClose(@Param("profileclose") Boolean profileClose);
    @Query("select a from Authenticate a where a.login = :login")
    Authenticate findByLogin(@Param("login") String login);
    @Query("select a from Authenticate a where a.id = :id")
    Authenticate findByLId(@Param("id") long id);
}
