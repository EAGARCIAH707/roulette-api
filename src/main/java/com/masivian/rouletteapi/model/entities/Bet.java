package com.masivian.rouletteapi.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Bet implements Serializable {
    @Id
    String betId;
    String color;
    Integer number;
    Double amount;
    String rouletteId;
    User user;
    Date date;


}
