package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface LetterRepository extends JpaRepository<Letter, Long> {
    @Query(nativeQuery = true, value = "select text_letter from m_letter  where id = ?")
    Letter findByLId(long id);

    @Query("select l from Letter l where l.id = :id")
    Letter findByIdLetter(long id);

    @Query("select l from Letter l where l.letterRemote = :letterRemote")
    List<Letter> findByLetterList(@Param("letterRemote") Boolean letterRemote);

}
