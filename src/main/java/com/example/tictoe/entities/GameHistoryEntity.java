package com.example.tictoe.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "GameHistory", schema = "Main")
public class GameHistoryEntity {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;

    @Column(name = "winner")
    private String winner;

    @Column(name = "board_result")
    private String boardResult;

    @Column(name = "date_created")
    private Date dateCreated;
}
