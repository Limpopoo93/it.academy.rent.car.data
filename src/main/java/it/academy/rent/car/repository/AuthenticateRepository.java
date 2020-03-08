package it.academy.rent.car.repository;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
    @Query(nativeQuery = true, value = "select authenticate from authenticate  where login = ? and password = ?")
    Authenticate findByLoginAndPassword(String login, String password);
    @Query(nativeQuery = true, value = "select authenticate from authenticate  where profileclose = ?")
    List<Authenticate> findByProfileClose(Boolean profileClose);
    @Query(nativeQuery = true, value = "select authenticate from authenticate  where login = ?")
    Authenticate findByLogin(String login);
    @Query(nativeQuery = true, value = "select authenticate from authenticate  where id = ?")
    Authenticate findByLId(long id);
}
