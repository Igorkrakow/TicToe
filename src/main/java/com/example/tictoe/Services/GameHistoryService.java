package com.example.tictoe.Services;


import com.example.tictoe.entities.GameHistoryEntity;
import com.example.tictoe.repositories.GameHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameHistoryService {
    private final GameHistoryRepository repository;

    public GameHistoryService(GameHistoryRepository repository){
        this.repository = repository;
    }
    public void generateAndSaveTransaction(String [] result,String winner) {
        GameHistoryEntity transaction = new GameHistoryEntity();
        transaction.setBoardResult(String.join(" ",result));
        transaction.setWinner(winner);
        transaction.setDateCreated(new Date());
        repository.save(transaction);
        System.out.println("\nTransaction saved.");
    }
    public void getStatisticks(){
        List<GameHistoryEntity> allGames = repository.findAll();
        Map<String, Long> stats = allGames.stream()
                .collect(Collectors.groupingBy(GameHistoryEntity::getWinner, Collectors.counting()));
        stats.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.println("\nWinner: " + entry.getKey() + " | Count: " + entry.getValue())
                );
    }

}
