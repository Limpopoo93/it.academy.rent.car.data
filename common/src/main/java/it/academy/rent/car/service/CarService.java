package it.academy.rent.car.service;

import it.academy.rent.car.bean.Car;

import java.util.List;

public interface CarService {
    Car save(Car car);

    Car findById(Long id);

    List<Car> findByIdCompany(Long id, Boolean isDelete);

    List<Car> findAll();

    Car saveAndFlush(Car car);
}
