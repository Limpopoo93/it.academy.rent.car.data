package it.academy.rent.car.repository;

import it.academy.rent.car.bean.PhotoCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoCarRepository extends JpaRepository<PhotoCar, Long> {
}
