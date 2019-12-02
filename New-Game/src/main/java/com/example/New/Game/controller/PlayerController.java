package com.example.New.Game.controller;


import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.New.Game.models.PlayerInfo;
import com.example.New.Game.repository.PlayerRepository;


@RestController
@RequestMapping("/playerinfo")
public class PlayerController {

	@Autowired
	 PlayerRepository playerRepository;
	
	@PostMapping("/player")
	 public PlayerInfo addNewplayer(@RequestBody PlayerInfo playerInfo)
	 {
		if(!playerRepository.existsById(playerInfo.getEmail()))
			playerRepository.save(playerInfo);
	  return playerInfo;
	 }
	
	@GetMapping("/allplayers")
	 public List<PlayerInfo> getAllPlayers()
	 {
		return playerRepository.findAll();
	 }
	
	@GetMapping("/player/{id}")
	 public ResponseEntity<PlayerInfo> getPlayer(@PathVariable("id") String id)
	 {
		return playerRepository.findById(id)
				.map(mapper-> ResponseEntity.ok().body(mapper))
				.orElse(ResponseEntity.notFound().build());
	 }
	
	@PutMapping("/player/{id}")
	 public ResponseEntity<PlayerInfo> updatePlayer(@PathVariable("id") String id,
			 @RequestBody PlayerInfo playerInfo)
	 {
		return playerRepository.findById(id)
				.map(playerInfoData -> {
					playerInfoData.setFirstName(playerInfo.getFirstName());
					playerInfoData.setLastName(playerInfo.getLastName());
					PlayerInfo updatedPlayerInfo=playerRepository.save(playerInfoData);
					return ResponseEntity.ok().body(updatedPlayerInfo);
				})
				.orElse(ResponseEntity.notFound().build());
	 }
}
