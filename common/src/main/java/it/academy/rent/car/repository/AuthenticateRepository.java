package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Authenticate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthenticateRepository extends JpaRepository<Authenticate, Long> {

    Authenticate findByLoginAndPassword(String login, String password);

    List<Authenticate> findByProfileClose(Boolean profileClose);

    List<Authenticate> findByProfileRemote(Boolean profileRemote);

    Authenticate findByLogin(String login);

}
