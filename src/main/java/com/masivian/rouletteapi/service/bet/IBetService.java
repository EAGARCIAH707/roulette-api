package com.masivian.rouletteapi.service.bet;

import com.masivian.rouletteapi.commons.domains.generic.BetDTO;
import com.masivian.rouletteapi.commons.exceptions.BusinessException;

import java.util.List;

public interface IBetService {
    BetDTO createBet(BetDTO bet, Integer userId) throws BusinessException;

    List<BetDTO> closeBets(Integer rouletteId);
}
