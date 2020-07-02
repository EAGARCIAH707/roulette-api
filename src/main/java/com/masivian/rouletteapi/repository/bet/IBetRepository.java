package com.masivian.rouletteapi.repository.bet;

import com.masivian.rouletteapi.model.entities.Bet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBetRepository extends MongoRepository<Bet, Integer> {
}
