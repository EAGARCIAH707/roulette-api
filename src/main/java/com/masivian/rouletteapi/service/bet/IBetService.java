package com.masivian.rouletteapi.service.bet;

import com.masivian.rouletteapi.commons.domains.generic.BetDTO;
import com.masivian.rouletteapi.commons.exceptions.BusinessException;
import com.masivian.rouletteapi.commons.exceptions.NotFoundException;

import java.util.List;

public interface IBetService {
    BetDTO createBet(BetDTO bet, String userId) throws BusinessException, NotFoundException;

    List<BetDTO> closeBets(String rouletteId) throws NotFoundException, BusinessException;
}
