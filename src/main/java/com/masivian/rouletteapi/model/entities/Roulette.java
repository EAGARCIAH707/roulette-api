package com.masivian.rouletteapi.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Roulette implements Serializable {

    @Id
    Integer rouletteId;
    Boolean state;
    Timestamp openingDate;
    Timestamp closingDate;
}
