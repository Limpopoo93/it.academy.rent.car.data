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
    @Query("select c, cm from Car c join Company cm on cm.id = c.company.id where c.company.id in (select cm.id from cm join Town tw on cm.town.id = tw.id where tw.nameTown in (SELECT tw.nameTown from tw where tw.nameTown = :nameTown and tw.country.nameCountry = :nameCountry))")
    List<Car> findByTownByAndByCountry(@Param("nameTown") String nameTown, @Param("nameCountry") String nameCountry);
    @Query("select c from Car c where c.id = :id")
    Car findByCId(@Param("id") long id);
    @Query("select c from Car c where c.company.id = :id and c.carRemote = :carRemote ")
    List<Car> findByIdCompany(@Param("id") long id, @Param("carRemote") Boolean carRemote);
    List<Car> findByNameCarAndMakeCarAndCompanyNameCompany(@Param("nameCar") String nameCar,@Param("makeCar") String makeCar,@Param("nameCompany") String nameCompany);
   // @Query("select c from Car c where c.nameCar = :nameCar and c.typeCar = :typeCar and c.company.nameCompany = :nameCompany and c.company.town.town = :town and c.company.town.country.country = :country")
   // Car findByNameCarAndMakeCarAndCompanyNameCompany(@Param("nameCar") String nameCar,@Param("makeCar") String makeCar,@Param("nameCompany") String nameCompany,@Param("town") String town,@Param("country") String country);
}
