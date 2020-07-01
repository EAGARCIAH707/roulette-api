package com.masivian.rouletteapi.web.rest.bet;

import com.masivian.rouletteapi.commons.constants.api.IEndpointApi;
import com.masivian.rouletteapi.commons.constants.api.IEndpointBet;
import com.masivian.rouletteapi.commons.constants.messages.IResponseMessages;
import com.masivian.rouletteapi.commons.domains.generic.BetDTO;
import com.masivian.rouletteapi.commons.domains.response.BaseResponse;
import com.masivian.rouletteapi.commons.enums.TransactionState;
import com.masivian.rouletteapi.service.bet.IBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> bet(@RequestHeader("user-id") Integer userId,
                                 @RequestBody BetDTO bet) {
        BetDTO response = betService.createBet(bet, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.builder()
                .status(HttpStatus.CREATED)
                .body(response)
                .message(IResponseMessages.CREATED)
                .transactionState(TransactionState.OK)
                .build());
    }

    @PatchMapping(IEndpointBet.CLOSE)
    public ResponseEntity<?> closeBets(@PathVariable Integer rouletteId) {
        List<BetDTO> response = betService.closeBets(rouletteId);
        return ResponseEntity.status(HttpStatus.OK).body(BaseResponse.builder()
                .status(HttpStatus.OK)
                .body(response)
                .message(IResponseMessages.OK)
                .transactionState(TransactionState.OK)
                .build());
    }
}
