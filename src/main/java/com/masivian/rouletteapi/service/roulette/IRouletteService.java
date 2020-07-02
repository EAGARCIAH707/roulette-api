package com.masivian.rouletteapi.service.roulette;

import com.masivian.rouletteapi.commons.domains.generic.RouletteDTO;
import com.masivian.rouletteapi.commons.exceptions.BusinessException;
import com.masivian.rouletteapi.commons.exceptions.NotFoundException;
import com.masivian.rouletteapi.model.entities.Roulette;

import java.util.List;
import java.util.Optional;

public interface IRouletteService {
    RouletteDTO create(RouletteDTO roulette) throws BusinessException;

    List<RouletteDTO> findAll();

    Boolean openRoulette(String rouletteId) throws NotFoundException;

    Optional<Roulette> closeRoulette(String rouletteId) throws NotFoundException;

    Roulette findById(String rouletteId) throws NotFoundException;

}
