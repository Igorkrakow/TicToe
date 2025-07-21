package com.example.tictoe.Services;


import java.util.Random;

public class Player {
    public String xOrO;
    private int choice;

    public Player(String xOrO){
        this.xOrO = xOrO;
    }
    public void move(Desc d) {
        while (true) {
            choice = (int) (Math.random() * 9);
            if (d.getBoardCell(choice).equals("X") || d.getBoardCell(choice).equals("O")) {
            } else {
                d.setBoardCell(choice, xOrO);
                break;
            }
        }
    }
}
