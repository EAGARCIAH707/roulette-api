package com.masivian.rouletteapi.service.bet.impl;

import com.masivian.rouletteapi.commons.domains.generic.BetDTO;
import com.masivian.rouletteapi.repository.bet.impl.IBetFacade;
import com.masivian.rouletteapi.service.bet.IBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService implements IBetService {
    private final IBetFacade betFacade;

    @Autowired
    public BetService(IBetFacade betFacade) {
        this.betFacade = betFacade;
    }

    @Override
    public BetDTO createBet(BetDTO bet, Integer userId) {
        return null;
    }

    @Override
    public List<BetDTO> closeBets(Integer rouletteId) {
        return null;
    }
}
