package com.masivian.rouletteapi.commons.domains.generic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masivian.rouletteapi.model.entities.User;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class BetDTO implements Serializable {
    String betId;
    String color;
    Integer number;
    Double amount;
    String rouletteId;
    @JsonIgnore
    User user;
    Date date;
}
