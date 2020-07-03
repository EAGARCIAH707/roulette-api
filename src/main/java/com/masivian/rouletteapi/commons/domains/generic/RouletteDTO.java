package com.masivian.rouletteapi.commons.domains.generic;

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
public class RouletteDTO implements Serializable {
    String rouletteId;
    String name;
    Boolean state;
    Date openDate;
    Date closeDate;
}
