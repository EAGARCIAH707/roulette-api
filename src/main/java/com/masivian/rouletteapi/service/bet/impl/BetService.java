package com.masivian.rouletteapi.service.bet.impl;

import com.masivian.rouletteapi.commons.constants.messages.IErrorMessages;
import com.masivian.rouletteapi.commons.domains.generic.BetDTO;
import com.masivian.rouletteapi.commons.exceptions.BusinessException;
import com.masivian.rouletteapi.commons.exceptions.NotFoundException;
import com.masivian.rouletteapi.model.entities.Bet;
import com.masivian.rouletteapi.model.entities.Roulette;
import com.masivian.rouletteapi.model.entities.User;
import com.masivian.rouletteapi.repository.bet.impl.IBetFacade;
import com.masivian.rouletteapi.service.bet.IBetService;
import com.masivian.rouletteapi.service.roulette.IRouletteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BetService implements IBetService {
    private final IBetFacade betFacade;
    private final IRouletteService rouletteService;
    private ModelMapper modelMapper;

    @Autowired
    public BetService(IBetFacade betFacade, IRouletteService rouletteService, ModelMapper modelMapper) {
        this.betFacade = betFacade;
        this.rouletteService = rouletteService;
        this.modelMapper = modelMapper;
    }

    @Override
    public BetDTO createBet(BetDTO bet, String userId) throws BusinessException, NotFoundException {
        Bet entity = validators(bet);
        entity.setUser(User.builder().userId(userId).build());
        entity.setDate(Timestamp.from(Instant.now()));
        Optional<Bet> optBet = betFacade.save(entity);
        if (optBet.isPresent()) {
            return entityToDto(optBet.get());
        } else {
            throw new BusinessException(IErrorMessages.NOT_CREATE);
        }
    }

    @Override
    public List<BetDTO> closeBets(String rouletteId) throws NotFoundException, BusinessException {
        Optional<Roulette> result = rouletteService.closeRoulette(rouletteId);
        if (result.isPresent()) {
            return listEntityToListDto(findByRoulette(result.get()));
        }
        throw new BusinessException(IErrorMessages.NOT_CLOSE_ROULETTE);
    }

    private Bet validators(BetDTO bet) throws NotFoundException, BusinessException {
        validateAmount(bet);
        validateNumber(bet);
        validateRoulette(bet);
        return dtoToEntity(bet);
    }

    private void validateAmount(BetDTO bet) throws BusinessException {
        if (bet.getAmount() < 0 || bet.getAmount() > 10000) {
            throw new BusinessException(IErrorMessages.AMOUNT_EXCEEDED);
        }
    }

    private void validateNumber(BetDTO bet) throws BusinessException {
        if (bet.getNumber() != null) {
            if (bet.getNumber() < 0 || bet.getNumber() > 36) {
                throw new BusinessException(IErrorMessages.INVALID_NUMBER);
            }
        }
    }

    private void validateRoulette(BetDTO bet) throws BusinessException, NotFoundException {
        Roulette roulette = rouletteService.findById(bet.getRouletteId());
        if (!roulette.getState()) {
            throw new BusinessException(IErrorMessages.CLOSED_ROULETTE);
        }
    }

    private List<Bet> findByRoulette(Roulette roulette) {
        return betFacade.findByRoulette(roulette);
    }

    private BetDTO entityToDto(Bet bet) {
        return modelMapper.map(bet, BetDTO.class);
    }

    private Bet dtoToEntity(BetDTO bet) {
        return modelMapper.map(bet, Bet.class);
    }

    private List<BetDTO> listEntityToListDto(List<Bet> betList) {
        return betList.stream().map(b -> modelMapper.map(b, BetDTO.class)).collect(Collectors.toList());
    }
}
