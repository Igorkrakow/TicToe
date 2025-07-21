package com.example.tictoe.Services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void checkMove_whenCellIsFree() {
        Desc desc = new Desc();
        desc.board = new String[]{"1","X","X","O","X","O","X","X","O"};
        Player p = new Player("X");
        p.move(desc);
        Assertions.assertEquals("X",desc.getBoardCell(0));
    }
    @Test
    void checkMove_NotOverideOldValues() {
        Desc desc = new Desc();
        desc.board = new String[]{"1","X","X","O","X","O","X","X","O"};
        Player p = new Player("X");
        p.move(desc);
        Assertions.assertEquals("X",desc.getBoardCell(2));
        Assertions.assertEquals("O",desc.getBoardCell(3));
        Assertions.assertEquals("O",desc.getBoardCell(8));
    }
}