package it.academy.rent.car.service;

import it.academy.rent.car.bean.Letter;
import it.academy.rent.car.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterService {
    @Autowired
    private LetterRepository letterRepository;

    public Letter save(Letter letter) {
        return letterRepository.save(letter);
    }

    public List<Letter> findByLetterList(Boolean isDelete) {
        return letterRepository.findByLetterList(isDelete);
    }

    public Letter findById(Long id) {
        return letterRepository.findById(id).orElse(null);
    }

    public Letter saveAndFlush(Letter letter) {
        return letterRepository.saveAndFlush(letter);
    }
}
