package com.masivian.rouletteapi.repository.bet.impl;

import com.masivian.rouletteapi.model.entities.Bet;

import java.util.Optional;

public interface IBetFacade {
    Optional<Bet> save(Bet entity);
}
