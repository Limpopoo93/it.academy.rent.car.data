package it.academy.rent.car.service;

import it.academy.rent.car.bean.BusyDate;

import java.util.Date;
import java.util.List;

public interface BusyDateService {
    List<BusyDate> findByBusyDate(Date dateCheck, Date dateReturn);

    BusyDate save(BusyDate busyDate);

    List<BusyDate> findByAuthenticateIdAndBusyDateRemote(Long id, Boolean isDelete);

    BusyDate findById(Long id);

    BusyDate saveAndFlush(BusyDate busyDate);
}
