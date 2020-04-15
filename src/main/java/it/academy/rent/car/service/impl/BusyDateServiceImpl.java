package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.BusyDate;
import it.academy.rent.car.repository.BusyDateRepository;
import it.academy.rent.car.service.BusyDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BusyDateServiceImpl implements BusyDateService {
    private final BusyDateRepository busyDateRepository;

    @Override
    public List<BusyDate> findByBusyDate(Date dateCheck, Date dateReturn) {
        return busyDateRepository.findByBusyDate(dateCheck, dateReturn);
    }

    @Transactional
    @Override
    public BusyDate save(BusyDate busyDate) {
        return busyDateRepository.save(busyDate);
    }

    @Override
    public List<BusyDate> findByAuthenticateIdAndBusyDateRemote(Long id, Boolean isDelete) {
        return busyDateRepository.findByAuthenticateIdAndBusyDateRemote(id, isDelete);
    }

    @Override
    public BusyDate findById(Long id) {
        return busyDateRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public BusyDate saveAndFlush(BusyDate busyDate) {
        return busyDateRepository.saveAndFlush(busyDate);
    }
}
