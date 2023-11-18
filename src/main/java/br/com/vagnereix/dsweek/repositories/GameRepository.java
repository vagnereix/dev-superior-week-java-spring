package br.com.vagnereix.dsweek.repositories;

import br.com.vagnereix.dsweek.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {}
