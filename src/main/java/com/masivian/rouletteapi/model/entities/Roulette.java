package com.masivian.rouletteapi.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@XmlRootElement
@EqualsAndHashCode
@Data
public class Roulette implements Serializable {

    @Id
    Integer rouletteId;
}
