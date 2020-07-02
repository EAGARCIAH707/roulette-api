package com.masivian.rouletteapi.commons.exceptions;

import com.masivian.rouletteapi.commons.constants.messages.IErrorMessages;
import com.masivian.rouletteapi.commons.domains.response.BaseResponse;
import com.masivian.rouletteapi.commons.enums.TransactionState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> systemException(Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(BaseResponse.builder()
                .status(HttpStatus.CONFLICT)
                .body(IErrorMessages.CONFLICT)
                .message(e.getMessage())
                .transactionState(TransactionState.FAIL)
                .build());
    }
}
