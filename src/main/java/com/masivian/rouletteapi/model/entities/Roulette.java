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
public class Roulette implements Serializable {

    @Id
    String rouletteId;
    Boolean state;
    String name;
    Date openDate;
    Date closeDate;
}
