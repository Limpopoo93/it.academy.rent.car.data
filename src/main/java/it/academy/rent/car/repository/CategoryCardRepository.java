package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Car;
import it.academy.rent.car.bean.CategoryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CategoryCardRepository extends JpaRepository<CategoryCard, Long> {
}