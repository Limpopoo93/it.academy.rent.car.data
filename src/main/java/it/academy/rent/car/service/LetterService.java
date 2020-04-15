package it.academy.rent.car.service;

import it.academy.rent.car.bean.Letter;

import java.util.List;

public interface LetterService {
    Letter save(Letter letter);

    List<Letter> findByLetterRemote(Boolean isDelete);

    Letter findById(Long id);

    Letter saveAndFlush(Letter letter);

}
