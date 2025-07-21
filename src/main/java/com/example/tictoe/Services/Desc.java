package com.example.tictoe.Services;

public class Desc {
    public String[] board = {"1","2","3","4","5","6","7","8","9"};
    public String winner;

    public void showBoard(){
        System.out.println(board[0] + "|" + board[1] + "|" +board[2]);
        System.out.println("-----");
        System.out.println(board[3] + "|" + board[4] + "|" +board[5]);
        System.out.println("-----");
        System.out.println(board[6] + "|" + board[7] + "|" +board[8] + "\n");

    }

    public void setBoardCell(int i,String s){
        board[i] = s;
    }
    public String getBoardCell(int i){
        return board[i];
    }
    public boolean checkEmptyCells(){
        for( String s : board) {
            if (
                    !(s.equals("O") || s.equals("X")
                    )) {
                return true;
            }
        }
        System.out.println("No winner no epmty cells");
        winner = "No winners";
        return false;
    }

    public boolean checkWinning(Player p){
        if(board[0].equals(p.xOrO) && board[1].equals(p.xOrO) && board[2].equals(p.xOrO)){
            System.out.println("Player " + p.xOrO + " won");
            winner = p.xOrO;
            return true;
        }
        else if (board[3].equals(p.xOrO) && board[4].equals(p.xOrO) && board[5].equals(p.xOrO)) {
            System.out.println("Player " + p.xOrO + " won");
            winner = p.xOrO;

            return true;
        }
        else if (board[6].equals(p.xOrO) && board[7].equals(p.xOrO) && board[8].equals(p.xOrO)) {
            System.out.println("Player " + p.xOrO + " won");
            winner = p.xOrO;
            return true;
        }

        else if (board[0].equals(p.xOrO) && board[3].equals(p.xOrO) && board[6].equals(p.xOrO)) {
            System.out.println("Player " + p.xOrO + " won");
            winner = p.xOrO;
            return true;
        }
        else if (board[1].equals(p.xOrO) && board[4].equals(p.xOrO) && board[7].equals(p.xOrO)) {
            System.out.println("Player " + p.xOrO + " won");
            winner = p.xOrO;
            return true;
        }
        else if (board[2].equals(p.xOrO) && board[5].equals(p.xOrO) && board[8].equals(p.xOrO)) {
            System.out.println("Player " + p.xOrO + " won");
            winner = p.xOrO;
            return true;
        }

        else if (board[0].equals(p.xOrO) && board[4].equals(p.xOrO) && board[8].equals(p.xOrO)) {
            System.out.println("Player " + p.xOrO + " won");
            winner = p.xOrO;
            return true;
        }
        else if (board[2].equals(p.xOrO) && board[4].equals(p.xOrO) && board[6].equals(p.xOrO)) {
            System.out.println("Player " + p.xOrO + " won");
            winner = p.xOrO;
            return true;
        }
        else return false;
    }
}
