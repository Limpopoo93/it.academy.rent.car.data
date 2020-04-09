package it.academy.rent.car.service;

import it.academy.rent.car.bean.BusyDate;
import it.academy.rent.car.repository.BusyDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class BusyDateService {
    @Autowired
    private BusyDateRepository busyDateRepository;

    public List<BusyDate> findByBusyDate(Date dateCheck, Date dateReturn) {
        return busyDateRepository.findByBusyDate(dateCheck, dateReturn);
    }

    public BusyDate save(BusyDate busyDate) {
        return busyDateRepository.save(busyDate);
    }

    public List<BusyDate> findByAuthenticateIdAndBusyDateRemote(Long id, Boolean isDelete) {
        return busyDateRepository.findByAuthenticateIdAndBusyDateRemote(id, isDelete);
    }

    public BusyDate findById(Long id) {
        return busyDateRepository.findById(id).orElse(null);
    }

    public BusyDate saveAndFlush(BusyDate busyDate) {
        return busyDateRepository.saveAndFlush(busyDate);
    }
}
