package com.masivian.rouletteapi.web.api.rest;

import com.masivian.rouletteapi.commons.constants.api.IEndpointApi;
import com.masivian.rouletteapi.commons.constants.messages.IResponseMessages;
import com.masivian.rouletteapi.commons.domains.response.BaseResponse;
import com.masivian.rouletteapi.commons.enums.TransactionState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = IEndpointApi.BASE_PATH)
@CrossOrigin(origins = "*")
public class RouletteApi {

    public ResponseEntity<?> createRoulette() {
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.builder()
                .status(HttpStatus.CREATED)
                .body("")
                .message(IResponseMessages.CREATED)
                .transactionState(TransactionState.FAIL)
                .build());
    }
}
