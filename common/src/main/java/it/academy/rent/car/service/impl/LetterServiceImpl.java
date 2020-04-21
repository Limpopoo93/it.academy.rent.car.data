package it.academy.rent.car.service.impl;

import it.academy.rent.car.bean.Letter;
import it.academy.rent.car.repository.LetterRepository;
import it.academy.rent.car.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService {
    private final LetterRepository letterRepository;

    @Transactional
    @Override
    public Letter save(Letter letter) {
        return letterRepository.save(letter);
    }

    @Override
    public List<Letter> findByLetterRemote(Boolean isDelete) {
        return letterRepository.findByLetterRemote(isDelete);
    }

    @Override
    public Letter findById(Long id) {
        return letterRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Letter saveAndFlush(Letter letter) {
        return letterRepository.saveAndFlush(letter);
    }
}
