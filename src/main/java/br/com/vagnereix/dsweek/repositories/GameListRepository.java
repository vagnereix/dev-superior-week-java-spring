package br.com.vagnereix.dsweek.repositories;

import br.com.vagnereix.dsweek.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {}
