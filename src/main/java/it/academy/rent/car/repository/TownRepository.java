package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Country;
import it.academy.rent.car.bean.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TownRepository extends JpaRepository<Town, Long> {
    @Query("select t from Town t where t.town = :town and t.country.country =:country")
    Town findByTownByCountry(@Param("town") String town, @Param("country") String country);
    List<Town> findByCountry(Country country);
    @Query("select t from Town t where t.id = :id")
    Town findByAId(long id);
}
