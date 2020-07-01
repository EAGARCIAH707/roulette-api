package com.masivian.rouletteapi.repository.roulette.impl;

import com.masivian.rouletteapi.repository.roulette.IRouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouletteRepository implements IRouletteFacade {
    private final IRouletteRepository rouletteRepository;

    @Autowired
    public RouletteRepository(IRouletteRepository rouletteRepository) {
        this.rouletteRepository = rouletteRepository;
    }
}
