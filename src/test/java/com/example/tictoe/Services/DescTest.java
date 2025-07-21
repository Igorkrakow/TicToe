package com.example.tictoe.Services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescTest {

    @Test
    void checkEmptyCells_WhenEmptyCellsExist_ReturnsTrue() {
        Desc desc = new Desc();
        desc.board = new String[]{"X","X","X","4","X","X","X","X","X"};
        boolean result = desc.checkEmptyCells();
        Assertions.assertTrue(result);
    }
    @Test
    void checkEmptyCells_WhenEmptyCellNotExist_ReturnsFalse() {
        Desc desc = new Desc();
        desc.board = new String[]{"X","O","X","O","X","O","X","X","O"};
        boolean result = desc.checkEmptyCells();
        Assertions.assertFalse(result);
    }

    @Test
    void checkWinning_WhenWinningExist_ReturnTrue() {
        Desc desc = new Desc();
        desc.board = new String[]{"X","X","X","O","X","O","X","X","O"};
        boolean result = desc.checkWinning(new Player("X"));
        Assertions.assertTrue(result);
    }
    @Test
    void checkWinning_WhenWinningNotExist_ReturnFalse() {
        Desc desc = new Desc();
        desc.board = new String[]{"O","X","X","O","X","O","X","X","O"};
        boolean result = desc.checkWinning(new Player("X"));
        Assertions.assertTrue(result);
    }
}