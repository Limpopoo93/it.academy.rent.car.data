package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Authenticate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AuthenticateRepository extends JpaRepository<Authenticate, Long> {

    Authenticate findByLoginAndPassword (String login, String password);

    List<Authenticate> findByProfileClose(Boolean profileClose);

    Authenticate findByLogin(String login);
    @Query("select a from Authenticate a where a.id = :id")
    Authenticate findByAId(long id);
}
