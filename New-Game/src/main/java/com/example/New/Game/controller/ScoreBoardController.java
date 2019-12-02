package com.example.New.Game.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.New.Game.models.ScoreBoardInfo;
import com.example.New.Game.repository.ScoreBoardRepository;

@RestController
@RequestMapping("/scoreinfo")
public class ScoreBoardController {

	@Autowired
	ScoreBoardRepository scoreBoardRepository;
	
	@PutMapping("/score/{id}")
	 public ResponseEntity<ScoreBoardInfo> updateScoreForPlayer(@PathVariable("id") String id,
			 @RequestBody ScoreBoardInfo scoreBoardInfo)
	 {
		if(scoreBoardRepository.existsById(id))
			return scoreBoardRepository.findById(id)
					.map(scoreBoardInfoData -> {
						if(scoreBoardInfoData.getScore()<scoreBoardInfo.getScore()) {
						scoreBoardInfoData.setScore(scoreBoardInfo.getScore());
						ScoreBoardInfo updatedScoreBoard=scoreBoardRepository.save(scoreBoardInfoData);
						return ResponseEntity.ok().body(updatedScoreBoard);
						}
						return ResponseEntity.ok().body(scoreBoardInfoData);
					})
					.orElse(ResponseEntity.notFound().build());
		else
			return ResponseEntity.ok().body(addNewUsersScore(scoreBoardInfo));
	 }
	
	 public ScoreBoardInfo addNewUsersScore(ScoreBoardInfo scoreBoardInfo)
	 {
		 return scoreBoardRepository.save(scoreBoardInfo);
	 }
	
	@GetMapping("/score/{id}")
	 public ResponseEntity<ScoreBoardInfo> getScoreForPlayer(@PathVariable("id") String id)
	 {
		 return scoreBoardRepository.findById(id)
		 .map(scoreBoardInfo -> ResponseEntity.ok().body(scoreBoardInfo))
		 .orElse(ResponseEntity.notFound().build());
	 }
	
	@GetMapping("/score")
	 public List<ScoreBoardInfo> getScoreBoard()
	 {
		 return scoreBoardRepository.findAll(Sort.by(Sort.Direction.DESC,"score"));
	 }
	 
}
