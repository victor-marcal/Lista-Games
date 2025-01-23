package com.intensivaojava.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intensivaojava.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
