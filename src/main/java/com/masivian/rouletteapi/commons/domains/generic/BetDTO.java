package com.masivian.rouletteapi.commons.domains.generic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masivian.rouletteapi.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
