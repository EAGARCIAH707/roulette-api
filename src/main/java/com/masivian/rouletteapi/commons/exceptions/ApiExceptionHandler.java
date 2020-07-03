package com.masivian.rouletteapi.commons.exceptions;

import com.masivian.rouletteapi.commons.constants.messages.IErrorMessages;
import com.masivian.rouletteapi.commons.domains.response.BaseResponse;
import com.masivian.rouletteapi.commons.enums.TransactionState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice()
public class ApiExceptionHandler {
    private static Logger logger = LogManager.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> systemException(Exception e) {
        logger.error(IErrorMessages.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(IErrorMessages.INTERNAL_SERVER_ERROR)
                .message(e.getMessage())
                .transactionState(TransactionState.FAIL)
                .timeResponse(Timestamp.from(Instant.now()))
                .build());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> businessException(BusinessException e) {
        logger.error(IErrorMessages.BUSINESS_EXCEPTION);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(BaseResponse.builder()
                .status(HttpStatus.CONFLICT)
                .body(IErrorMessages.BUSINESS_EXCEPTION)
                .message(e.getMessage())
                .transactionState(TransactionState.FAIL)
                .timeResponse(Timestamp.from(Instant.now()))
                .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e) {
        logger.error(IErrorMessages.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .body(IErrorMessages.NOT_FOUND)
                .message(e.getMessage())
                .transactionState(TransactionState.FAIL)
                .timeResponse(Timestamp.from(Instant.now()))
                .build());
    }
}
