package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LetterRepository extends JpaRepository<Letter, Long> {
    @Query(nativeQuery = true, value = "select text_letter from letter  where id = ?")
    Letter findByLId(long id);
}
