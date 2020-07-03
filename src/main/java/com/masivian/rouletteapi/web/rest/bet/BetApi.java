package com.masivian.rouletteapi.web.rest.bet;

import com.masivian.rouletteapi.commons.constants.api.IEndpointApi;
import com.masivian.rouletteapi.commons.constants.api.IEndpointBet;
import com.masivian.rouletteapi.commons.constants.messages.IResponseMessages;
import com.masivian.rouletteapi.commons.domains.generic.BetDTO;
import com.masivian.rouletteapi.commons.domains.response.BaseResponse;
import com.masivian.rouletteapi.commons.enums.TransactionState;
import com.masivian.rouletteapi.commons.exceptions.BusinessException;
import com.masivian.rouletteapi.commons.exceptions.NotFoundException;
import com.masivian.rouletteapi.service.bet.IBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = IEndpointApi.BASE_PATH)
@CrossOrigin(origins = "*")
public class BetApi {
    private final IBetService betService;

    @Autowired
    public BetApi(IBetService betService) {
        this.betService = betService;
    }

    @PostMapping(IEndpointBet.CREATE)
    public ResponseEntity<?> createBet(@RequestHeader("user-id") String userId,
                                       @RequestBody BetDTO bet) throws BusinessException, NotFoundException {
        BetDTO response = betService.createBet(bet, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.builder()
                .status(HttpStatus.CREATED)
                .body(response)
                .message(IResponseMessages.CREATED)
                .transactionState(TransactionState.OK)
                .path(IEndpointApi.BASE_PATH.concat(IEndpointBet.CREATE))
                .timeResponse(Timestamp.from(Instant.now()))
                .build());
    }

    @PatchMapping(IEndpointBet.CLOSE)
    public ResponseEntity<?> closeBets(@PathVariable String rouletteId) throws NotFoundException, BusinessException {
        List<BetDTO> response = betService.closeBets(rouletteId);
        return ResponseEntity.status(HttpStatus.OK).body(BaseResponse.builder()
                .status(HttpStatus.OK)
                .body(response)
                .message(IResponseMessages.OK)
                .transactionState(TransactionState.OK)
                .path(IEndpointApi.BASE_PATH.concat(IEndpointBet.CLOSE))
                .timeResponse(Timestamp.from(Instant.now()))
                .build());
    }
}
