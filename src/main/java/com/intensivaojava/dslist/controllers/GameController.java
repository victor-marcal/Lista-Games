package com.intensivaojava.dslist.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//import com.intensivaojava.dslist.entities.Game;
import com.intensivaojava.dslist.services.GameService;
import com.intensivaojava.dslist.dto.GameDTO;
import com.intensivaojava.dslist.dto.GameMinDTO;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;

	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
