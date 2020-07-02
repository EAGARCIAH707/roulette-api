package com.masivian.rouletteapi.repository.roulette.impl;

import com.masivian.rouletteapi.model.entities.Roulette;

import java.util.List;
import java.util.Optional;

public interface IRouletteFacade {
    Optional<Roulette> save(Roulette roulette);

    List<Roulette> findALl();

    Optional<Roulette> findById(Integer rouletteId);
}
