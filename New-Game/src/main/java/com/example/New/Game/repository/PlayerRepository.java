package com.example.New.Game.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.New.Game.models.PlayerInfo;

public interface PlayerRepository extends MongoRepository<PlayerInfo, String> {
	
}
