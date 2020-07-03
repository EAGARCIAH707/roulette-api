package com.masivian.rouletteapi.repository.bet.impl;

import com.masivian.rouletteapi.model.entities.Bet;
import com.masivian.rouletteapi.model.entities.Roulette;

import java.util.List;
import java.util.Optional;

public interface IBetFacade {
    Optional<Bet> save(Bet entity);

    List<Bet> findByRoulette(Roulette roulette);
}
