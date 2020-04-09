package it.academy.rent.car.service;

import it.academy.rent.car.repository.PhotoCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoCarService {
    @Autowired
    private PhotoCarRepository photoCarRepository;
}
