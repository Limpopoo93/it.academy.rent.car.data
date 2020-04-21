package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Car;
import it.academy.rent.car.bean.CarSearch;
import it.academy.rent.car.repository.CarRepository;
import it.academy.rent.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public Long daysBetween(Date d1, Date d2) {
        return ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public List<Car> list(CarSearch carSearch) {
        List<Car> cars = carRepository.findByTownByAndByCountry(carSearch.getTown(), carSearch.getCountry());
        for (Car car : cars) {
            Long price = car.getPrice();
            Date dateCheck = carSearch.getDateCheck();
            Date dateReturn = carSearch.getDateReturn();
            Long colDay = daysBetween(dateCheck, dateReturn);
            Long finalPrice = price * colDay;
            car.setPrice(finalPrice);
        }
        return cars;
    }

    @Transactional
    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> findByIdCompany(Long id, Boolean isDelete) {
        return carRepository.findByIdCompany(id, isDelete);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Transactional
    @Override
    public Car saveAndFlush(Car car) {
        return carRepository.saveAndFlush(car);
    }
}
