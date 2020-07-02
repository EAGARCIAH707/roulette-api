package com.masivian.rouletteapi.web.rest.roulette;

import com.masivian.rouletteapi.commons.constants.api.IEndpointApi;
import com.masivian.rouletteapi.commons.constants.api.IEndpointRoulette;
import com.masivian.rouletteapi.commons.constants.messages.IResponseMessages;
import com.masivian.rouletteapi.commons.domains.generic.RouletteDTO;
import com.masivian.rouletteapi.commons.domains.response.BaseResponse;
import com.masivian.rouletteapi.commons.enums.TransactionState;
import com.masivian.rouletteapi.commons.exceptions.BusinessException;
import com.masivian.rouletteapi.commons.exceptions.NotFoundException;
import com.masivian.rouletteapi.service.roulette.IRouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = IEndpointApi.BASE_PATH)
@CrossOrigin(origins = "*")
public class RouletteApi {
    private final IRouletteService rouletteService;

    @Autowired
    public RouletteApi(IRouletteService rouletteService) {
        this.rouletteService = rouletteService;
    }

    @PostMapping(IEndpointRoulette.CREATE)
    public ResponseEntity<?> createRoulette(@RequestBody RouletteDTO roulette) throws BusinessException {
        RouletteDTO response = rouletteService.create(roulette);
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.builder()
                .status(HttpStatus.CREATED)
                .body(response)
                .message(IResponseMessages.CREATED)
                .transactionState(TransactionState.OK)
                .build());
    }

    @GetMapping(IEndpointRoulette.FIND_ALL)
    public ResponseEntity<?> listAll() {
        List<RouletteDTO> response = rouletteService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(BaseResponse.builder()
                .status(HttpStatus.OK)
                .body(response)
                .message(IResponseMessages.OK)
                .transactionState(TransactionState.OK)
                .build());
    }

    @PatchMapping(IEndpointRoulette.OPEN)
    public ResponseEntity<?> openRoulette(@PathVariable String rouletteId) throws NotFoundException {
        Boolean response = rouletteService.openRoulette(rouletteId);
        return ResponseEntity.status(HttpStatus.OK).body(BaseResponse.builder()
                .status(HttpStatus.OK)
                .body(response)
                .message(IResponseMessages.OK)
                .transactionState(TransactionState.OK)
                .build());
    }
}
