package com.example.tictoe.repositories;

import com.example.tictoe.entities.GameHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameHistoryRepository extends JpaRepository <GameHistoryEntity, Long> {
}
