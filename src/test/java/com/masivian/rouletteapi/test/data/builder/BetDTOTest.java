package com.masivian.rouletteapi.test.data.builder;

import com.masivian.rouletteapi.commons.domains.generic.BetDTO;

public class BetDTOTest {
    String color;
    Integer number;
    Double amount;
    String rouletteId;

    public BetDTOTest() {
        this.color = "red";
        this.number = 36;
        this.amount = 100000.0;
        this.rouletteId = "1";
    }

    public BetDTO betBuilder() {
        return BetDTO.builder()
                .color(this.color)
                .number(this.number)
                .amount(this.amount)
                .rouletteId(this.rouletteId)
                .build();
    }
}
