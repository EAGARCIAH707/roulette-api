package com.masivian.rouletteapi.repository.bet.impl;

import com.masivian.rouletteapi.model.entities.Bet;
import com.masivian.rouletteapi.repository.bet.IBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BetRepository implements IBetFacade {
    private final IBetRepository betRepository;

    @Autowired
    public BetRepository(IBetRepository betRepository) {
        this.betRepository = betRepository;
    }

    @Override
    public Optional<Bet> save(Bet entity) {
        return Optional.of(betRepository.save(entity));
    }
}
