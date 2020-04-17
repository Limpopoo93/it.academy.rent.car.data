package it.academy.rent.car.service;

import it.academy.rent.car.bean.Town;

import java.util.List;

public interface TownService {
    Town saveAndFlush(Town town);

    List<Town> findByCountry(String country, Boolean isDelete);

    Town findById(Long id);
}
