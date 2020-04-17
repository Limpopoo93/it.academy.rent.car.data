package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {

    List<Letter> findByLetterRemote(Boolean letterRemote);

}
