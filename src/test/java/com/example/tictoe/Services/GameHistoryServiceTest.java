package com.example.tictoe.Services;

import com.example.tictoe.entities.GameHistoryEntity;
import com.example.tictoe.repositories.GameHistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class GameHistoryServiceTest {
    @Mock
    private GameHistoryRepository repository;
    @InjectMocks
    private GameHistoryService service;
    @Test
    void generateAndSaveTransaction() {
        String[] board = {"X", "O", "X", "O", "X", "O", "X", "O", "X"};
        String winner = "X";

        //объект captor будет перехватывать аргументы, переданные в мокнутые методы
        ArgumentCaptor<GameHistoryEntity> captor = ArgumentCaptor.forClass(GameHistoryEntity.class);
        //Вызываем
        service.generateAndSaveTransaction(board, winner);
        //перехват
        verify(repository).save(captor.capture());
        //Сохраняем
        GameHistoryEntity saved = captor.getValue();

        assertEquals("X O X O X O X O X", saved.getBoardResult());
        assertEquals("X", saved.getWinner());
        assertNotNull(saved.getDateCreated());
        assertNotNull(saved.getGameId());;
    }

    @Test
    void getStatisticks() {
        GameHistoryEntity game1 = new GameHistoryEntity();
        game1.setWinner("X");

        GameHistoryEntity game2 = new GameHistoryEntity();
        game2.setWinner("O");

        GameHistoryEntity game3 = new GameHistoryEntity();
        game3.setWinner("X");

        List<GameHistoryEntity> mockGames = Arrays.asList(game1, game2, game3);

        //подменяет реальный вызов с базы и при вызове просто возвращает уже готовый обьект созданый выше
        when(repository.findAll()).thenReturn(mockGames);

        String output = service.getStatisticks().toString();
        //првоеряет что что метод был вызван 1 раз
        verify(repository, times(1)).findAll();

        assertEquals("\nWinner: X | Count: 2" +
                "\nWinner: O | Count: 1",output);
    }
}