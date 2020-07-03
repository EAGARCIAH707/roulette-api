package com.masivian.rouletteapi.commons.domains.response;

import com.masivian.rouletteapi.commons.enums.TransactionState;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
public class BaseResponse<T> implements Serializable {
    private T body;
    private HttpStatus status;
    private Timestamp timeResponse;
    private String message;
    private String path;
    private TransactionState transactionState;

    public BaseResponse(T body, HttpStatus status, Timestamp timeResponse, String message, String path, TransactionState transactionState) {
        this.body = body;
        this.status = status;
        this.timeResponse = timeResponse;
        this.message = message;
        this.path = path;
        this.transactionState = transactionState;
    }
}
