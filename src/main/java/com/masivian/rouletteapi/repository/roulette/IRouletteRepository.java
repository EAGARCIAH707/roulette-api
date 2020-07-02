package com.masivian.rouletteapi.repository.roulette;

import com.masivian.rouletteapi.model.entities.Roulette;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IRouletteRepository extends MongoRepository<Roulette, Integer> {
}
