package com.masivian.rouletteapi.commons.constants.messages;

public interface IErrorMessages {
    String CONFLICT = "an error occurred in the application";
    String BUSINESS_EXCEPTION = "a business rule is not being followed, therefore it was not possible to continue with the operation";
    String NOT_CREATE = "the resource could not be created";
    String NOT_FOUND = "The requested resource was not found";
    String NOT_CLOSE_ROULETTE = "it was not possible to close the specified roulette";
    String CLOSED_ROULETTE = "the roulette you are trying to access is not open";
    String AMOUNT_EXCEEDED = "bet amount exceeds allowable";
    String INVALID_NUMBER = "the number for the bet is out of range";
    Object INTERNAL_SERVER_ERROR = "an internal error occurred in the application, contact the administrator";
}
