package com.masivian.rouletteapi.service.roulette;

import com.masivian.rouletteapi.commons.domains.generic.RouletteDTO;

import java.util.List;

public interface IRouletteService {
    RouletteDTO create(RouletteDTO roulette);

    List<RouletteDTO> findAll();

    Boolean openRoulette(Integer rouletteId);
}
