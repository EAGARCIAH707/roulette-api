package com.masivian.rouletteapi.service.roulette.impl;

import com.masivian.rouletteapi.commons.constants.messages.IErrorMessages;
import com.masivian.rouletteapi.commons.domains.generic.RouletteDTO;
import com.masivian.rouletteapi.commons.exceptions.BusinessException;
import com.masivian.rouletteapi.commons.exceptions.NotFoundException;
import com.masivian.rouletteapi.model.entities.Roulette;
import com.masivian.rouletteapi.repository.roulette.impl.IRouletteFacade;
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
public class RouletteService implements IRouletteService {
    private final IRouletteFacade rouletteFacade;
    private ModelMapper modelMapper;

    @Autowired
    public RouletteService(IRouletteFacade rouletteFacade, ModelMapper modelMapper) {
        this.rouletteFacade = rouletteFacade;
        this.modelMapper = modelMapper;
    }

    @Override
    public RouletteDTO create(RouletteDTO roulette) throws BusinessException {
        Roulette entity = dtoToEntity(roulette);
        Optional<Roulette> optRoulette = rouletteFacade.save(entity);
        if (optRoulette.isPresent()) {
            return entityToDto(Roulette.builder()
                    .rouletteId(optRoulette.get().getRouletteId())
                    .build());
        } else {
            throw new BusinessException(IErrorMessages.NOT_CREATE);
        }
    }

    @Override
    public List<RouletteDTO> findAll() {
        List<Roulette> rouletteList = rouletteFacade.findALl();
        return listEntityToListDto(rouletteList);
    }

    @Override
    public Boolean openRoulette(String rouletteId) throws NotFoundException {
        Roulette roulette = findById(rouletteId);
        roulette.setState(Boolean.TRUE);
        roulette.setOpenDate(Timestamp.from(Instant.now()));
        rouletteFacade.save(roulette);
        return Boolean.TRUE;
    }

    @Override
    public Optional<Roulette> closeRoulette(String rouletteId) throws NotFoundException {
        Roulette roulette = findById(rouletteId);
        roulette.setState(Boolean.FALSE);
        roulette.setCloseDate(Timestamp.from(Instant.now()));
        return rouletteFacade.save(roulette);
    }

    public Roulette findById(String rouletteId) throws NotFoundException {
        Optional<Roulette> optRoulette = rouletteFacade.findById(rouletteId);
        if (optRoulette.isPresent()) {
            return optRoulette.get();
        } else {
            throw new NotFoundException(IErrorMessages.NOT_FOUND);
        }
    }


    private Roulette dtoToEntity(RouletteDTO rouletteDTO) {
        return modelMapper.map(rouletteDTO, Roulette.class);
    }

    private RouletteDTO entityToDto(Roulette roulette) {
        return modelMapper.map(roulette, RouletteDTO.class);
    }

    private List<RouletteDTO> listEntityToListDto(List<Roulette> rouletteList) {
        return rouletteList.stream().map(p -> modelMapper.map(p, RouletteDTO.class))
                .collect(Collectors.toList());
    }
}
