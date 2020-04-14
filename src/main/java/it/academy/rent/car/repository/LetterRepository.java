package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface LetterRepository extends JpaRepository<Letter, Long> {

    List<Letter> findByLetterRemote(Boolean letterRemote);

}
