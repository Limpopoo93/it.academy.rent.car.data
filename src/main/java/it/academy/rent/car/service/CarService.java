package it.academy.rent.car.service;

import it.academy.rent.car.bean.Car;
import it.academy.rent.car.bean.CarSearch;
import it.academy.rent.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Long daysBetween(Date d1, Date d2) {
        return (long) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
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

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> findByIdCompany(Long id, Boolean isDelete) {
        return carRepository.findByIdCompany(id, isDelete);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car saveAndFlush(Car car) {
        return carRepository.saveAndFlush(car);
    }
}
