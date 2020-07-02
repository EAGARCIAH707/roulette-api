package com.masivian.rouletteapi.commons.domains.generic;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class RouletteDTO implements Serializable {
    String rouletteId;
    String name;
    Boolean state;
    Date openDate;
    Date closeDate;
}
