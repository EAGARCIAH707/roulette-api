package com.masivian.rouletteapi.service.bet.impl;

import com.masivian.rouletteapi.commons.constants.messages.IErrorMessages;
import com.masivian.rouletteapi.commons.domains.generic.BetDTO;
import com.masivian.rouletteapi.commons.exceptions.BusinessException;
import com.masivian.rouletteapi.model.entities.Bet;
import com.masivian.rouletteapi.repository.bet.impl.IBetFacade;
import com.masivian.rouletteapi.service.bet.IBetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetService implements IBetService {
    private final IBetFacade betFacade;
    private ModelMapper modelMapper;

    @Autowired
    public BetService(IBetFacade betFacade, ModelMapper modelMapper) {
        this.betFacade = betFacade;
        this.modelMapper = modelMapper;
    }

    @Override
    public BetDTO createBet(BetDTO bet, Integer userId) throws BusinessException {
        Bet entity = dtoToEntity(bet);
        Optional<Bet> optBet = betFacade.save(entity);
        if (optBet.isPresent()) {
            return entityToDto(optBet.get());
        } else {
            throw new BusinessException(IErrorMessages.NOT_CREATE);
        }
    }

    @Override
    public List<BetDTO> closeBets(Integer rouletteId) {

        return null;
    }

    private BetDTO entityToDto(Bet bet) {
        return modelMapper.map(bet, BetDTO.class);
    }

    private Bet dtoToEntity(BetDTO bet) {
        return modelMapper.map(bet, Bet.class);
    }
}
