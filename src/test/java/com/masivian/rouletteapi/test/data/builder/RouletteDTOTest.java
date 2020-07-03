package com.masivian.rouletteapi.test.data.builder;

import com.masivian.rouletteapi.commons.domains.generic.RouletteDTO;

public class RouletteDTOTest {
    String name;

    public RouletteDTOTest() {
        this.name = "name - test";
    }

    public RouletteDTO rouletteBuilder() {
        return RouletteDTO.builder().name(this.name).build();
    }
}
