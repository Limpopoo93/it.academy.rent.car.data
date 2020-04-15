package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Town;
import it.academy.rent.car.repository.TownRepository;
import it.academy.rent.car.service.TownService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    @Transactional
    @Override
    public Town saveAndFlush(Town town) {
        return townRepository.saveAndFlush(town);
    }

    @Override
    public List<Town> findByCountry(String country, Boolean isDelete) {
        return townRepository.findByCountry(country, isDelete);
    }

    @Override
    public Town findById(Long id) {
        return townRepository.findById(id).orElse(null);
    }
}
