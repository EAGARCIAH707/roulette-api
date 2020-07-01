package com.masivian.rouletteapi.service.bet;

import com.masivian.rouletteapi.commons.domains.generic.BetDTO;

import java.util.List;

public interface IBetService {
    BetDTO createBet(BetDTO bet, Integer userId);

    List<BetDTO> closeBets(Integer rouletteId);
}
