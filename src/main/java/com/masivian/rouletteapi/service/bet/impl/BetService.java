package com.masivian.rouletteapi.service.bet.impl;

import com.masivian.rouletteapi.commons.domains.generic.BetDTO;
import com.masivian.rouletteapi.service.bet.IBetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService implements IBetService {
    @Override
    public BetDTO createBet(BetDTO bet, Integer userId) {
        return null;
    }

    @Override
    public List<BetDTO> closeBets(Integer rouletteId) {
        return null;
    }
}
