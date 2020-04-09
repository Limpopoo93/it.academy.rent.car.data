package it.academy.rent.car.service;

import it.academy.rent.car.bean.Town;
import it.academy.rent.car.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownService {
    @Autowired
    private TownRepository townRepository;

    public Town saveAndFlush(Town town) {
        return townRepository.saveAndFlush(town);
    }

    public List<Town> findByCountry(String country, Boolean isDelete) {
        return townRepository.findByCountry(country, isDelete);
    }

    public Town findById(Long id) {
        return townRepository.findById(id).orElse(null);
    }
}
