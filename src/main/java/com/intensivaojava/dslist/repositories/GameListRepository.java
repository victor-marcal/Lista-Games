package com.intensivaojava.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intensivaojava.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
