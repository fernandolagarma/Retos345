package com.example.retos345.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retos345.entities.Score;

public interface ScoreRepository  extends JpaRepository<Score, Integer>{
}
