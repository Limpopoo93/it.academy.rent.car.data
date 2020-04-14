package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByCountryRemote(Boolean countryRemote);

    Country findByNameCountry(String nameCountry);
}
