package com.masivian.rouletteapi.service.roulette;

import com.masivian.rouletteapi.commons.domains.generic.RouletteDTO;
import com.masivian.rouletteapi.commons.exceptions.BusinessException;
import com.masivian.rouletteapi.commons.exceptions.NotFoundException;

import java.util.List;

public interface IRouletteService {
    RouletteDTO create(RouletteDTO roulette) throws BusinessException;

    List<RouletteDTO> findAll();

    Boolean openRoulette(Integer rouletteId) throws NotFoundException;

}
