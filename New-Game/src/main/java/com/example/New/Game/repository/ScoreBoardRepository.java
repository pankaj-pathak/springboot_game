package com.example.New.Game.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.New.Game.models.ScoreBoardInfo;

public interface ScoreBoardRepository extends MongoRepository<ScoreBoardInfo, String> {
	
}
