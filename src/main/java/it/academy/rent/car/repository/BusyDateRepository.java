package it.academy.rent.car.repository;

import it.academy.rent.car.bean.BusyDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface BusyDateRepository extends JpaRepository<BusyDate, Long> {
    @Query("select bd from BusyDate bd where :dateCheck between bd.dateCheck and bd.dateReturn or :dateReturn between bd.dateCheck and bd.dateReturn")
    List<BusyDate> findByBusyDate(@Param("dateCheck") Date dateCheck, @Param("dateReturn") Date dateReturn);
    List<BusyDate> findByAuthenticateIdAndBusyDateRemote(Long id, Boolean busyDateRemote);
}
