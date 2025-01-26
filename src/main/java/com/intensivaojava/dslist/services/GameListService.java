package com.intensivaojava.dslist.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.intensivaojava.dslist.dto.GameListDTO;
import com.intensivaojava.dslist.repositories.GameListRepository;
import com.intensivaojava.dslist.repositories.GameRepository;
import com.intensivaojava.dslist.entities.GameList;
import com.intensivaojava.dslist.projections.GameMinProjection;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired 
	private GameRepository gameRepository;
	

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	//Dado uma lista e uma posicao de origem e destino, rstou atualizando os jogos dentro dessa lista especificada
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i<=max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
	
	
}
