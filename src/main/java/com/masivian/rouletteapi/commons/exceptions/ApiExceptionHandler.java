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
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(IErrorMessages.INTERNAL_SERVER_ERROR)
                .message(e.getMessage())
                .transactionState(TransactionState.FAIL)
                .build());
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> businessException(BusinessException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(BaseResponse.builder()
                .status(HttpStatus.CONFLICT)
                .body(IErrorMessages.BUSINESS_EXCEPTION)
                .message(e.getMessage())
                .transactionState(TransactionState.FAIL)
                .build());
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .body(IErrorMessages.NOT_FOUND)
                .message(e.getMessage())
                .transactionState(TransactionState.FAIL)
                .build());
    }
}
