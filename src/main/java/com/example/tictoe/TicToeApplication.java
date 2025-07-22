package com.example.tictoe;

import com.example.tictoe.Services.Desc;
import com.example.tictoe.Services.GameHistoryService;
import com.example.tictoe.Services.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class TicToeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicToeApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner(GameHistoryService service) {
        return args -> {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Press to play");

                Desc d = new Desc();
                Player p1 = new Player("X");
                Player p2 = new Player("O");
                while (true) {
                    p1.move(d);
                    d.showBoard();
                    if(d.checkWinning(p1) || !d.checkEmptyCells()) break;
                    p2.move(d);
                    d.showBoard();
                    if(d.checkWinning(p2) || !d.checkEmptyCells() ) break;

                }
                service.generateAndSaveTransaction(d.board, d.winner);
                System.out.println(service.getStatisticks());
                break;
            }
        };
    }
}


