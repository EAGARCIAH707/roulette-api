package com.masivian.rouletteapi.service.roulette.impl;

import com.masivian.rouletteapi.commons.domains.generic.RouletteDTO;
import com.masivian.rouletteapi.service.roulette.IRouletteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouletteService implements IRouletteService {
    @Override
    public RouletteDTO create(RouletteDTO roulette) {
        return null;
    }

    @Override
    public List<RouletteDTO> findAll() {
        return null;
    }

    @Override
    public Boolean openRoulette(Integer rouletteId) {
        return null;
    }
}
