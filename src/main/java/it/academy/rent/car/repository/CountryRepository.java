package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query("select c from Country c where c.id = :id")
    Country findByCId(@Param("id") long id);
}
