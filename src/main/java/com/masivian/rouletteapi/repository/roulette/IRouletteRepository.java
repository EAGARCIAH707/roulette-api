package com.masivian.rouletteapi.repository.roulette;

import com.masivian.rouletteapi.model.entities.Roulette;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRouletteRepository extends MongoRepository<Roulette, Integer> {
}
