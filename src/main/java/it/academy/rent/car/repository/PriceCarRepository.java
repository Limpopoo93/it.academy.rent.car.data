package it.academy.rent.car.repository;

import it.academy.rent.car.bean.PriceCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PriceCarRepository extends JpaRepository<PriceCar, Long> {
    @Query("select p from PriceCar p where p.car.id = :id")
    PriceCar findByIdPriceByCar(@Param("id") long id);
}
