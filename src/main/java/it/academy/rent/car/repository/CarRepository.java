package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c, cm from Car c join Company cm on cm.id = c.company.id where c.company.id in (select cm.id from cm join Town tw on cm.town.id = tw.id where tw.town in (SELECT tw.town from tw where tw.town = :town and tw.country.country = :country))")
    List<Car> findByTownByAndByCountry(@Param("town") String town, @Param("country") String country);
    @Query("select c from Car c where c.id = :id")
    Car findByCId(@Param("id") long id);
    @Query("select c from Car c where c.company.id = :id")
    List<Car> findByIdCompany(@Param("id") long id);
    List<Car> findByNameCarAndMakeCarAndCompanyNameCompany(@Param("nameCar") String nameCar,@Param("makeCar") String makeCar,@Param("nameCompany") String nameCompany);
}
