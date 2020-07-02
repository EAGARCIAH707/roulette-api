package com.masivian.rouletteapi.repository.roulette.impl;

import com.masivian.rouletteapi.model.entities.Roulette;
import com.masivian.rouletteapi.repository.roulette.IRouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RouletteRepository implements IRouletteFacade {
    private final IRouletteRepository rouletteRepository;

    @Autowired
    public RouletteRepository(IRouletteRepository rouletteRepository) {
        this.rouletteRepository = rouletteRepository;
    }

    @Override
    public Optional<Roulette> save(Roulette roulette) {
        return Optional.of(rouletteRepository.save(roulette));
    }

    @Override
    public List<Roulette> findALl() {
        return rouletteRepository.findAll();
    }

    @Override
    public Optional<Roulette> findById(Integer rouletteId) {
        return rouletteRepository.findById(rouletteId);
    }
}
