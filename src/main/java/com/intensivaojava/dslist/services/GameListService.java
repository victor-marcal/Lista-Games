package com.intensivaojava.dslist.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.intensivaojava.dslist.dto.GameListDTO;
import com.intensivaojava.dslist.repositories.GameListRepository;
import com.intensivaojava.dslist.entities.GameList;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
