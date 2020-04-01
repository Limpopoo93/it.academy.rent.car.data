package it.academy.rent.car.repository;

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
    @Query("select t from Town t where t.nameTown = :nameTown and t.country.nameCountry =:nameCountry")
    Town findByTownByCountry(@Param("nameTown") String nameTown, @Param("nameCountry") String nameCountry);
    @Query("select t from Town t where t.country.nameCountry = :nameCountry and t.townRemote = :townRemote ")
    List<Town> findByCountry(@Param("nameCountry") String nameCountry, @Param("townRemote") Boolean townRemote);
    @Query("select t from Town t where t.id = :id")
    Town findByAId(long id);
}
