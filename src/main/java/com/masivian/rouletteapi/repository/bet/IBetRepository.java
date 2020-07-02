package com.masivian.rouletteapi.repository.bet;

import com.masivian.rouletteapi.model.entities.Bet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface IBetRepository extends MongoRepository<Bet, String> {
    List<Bet> findAllByDateBetweenAndRouletteId(Date startDate, Date endDate, String rouletteId);
}
