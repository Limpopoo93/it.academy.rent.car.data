package it.academy.rent.car.repository;

import it.academy.rent.car.bean.BusyDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BusyDateRepository extends JpaRepository<BusyDate, Long> {
}
