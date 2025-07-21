package com.example.tictoe.Services;

import com.example.tictoe.entities.GameHistoryEntity;
import com.example.tictoe.repositories.GameHistoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GameHistoryServiceTest {
    @Autowired
    private GameHistoryService service;
    @Autowired
    private GameHistoryRepository repository;

    @Test
    void generateAndSaveTransaction() {
        String[] board = {"X", "O", "X", "O", "X", "O", "X", "O", "X"};
        String winner = "X";

        service.generateAndSaveTransaction(board, winner);

        List<GameHistoryEntity> all = repository.findAll();

        GameHistoryEntity saved = all.get(all.size()-1);
        Assertions.assertEquals("X O X O X O X O X", saved.getBoardResult());
        Assertions.assertEquals("X", saved.getWinner());
        Assertions.assertNotNull(saved.getDateCreated());
    }
}