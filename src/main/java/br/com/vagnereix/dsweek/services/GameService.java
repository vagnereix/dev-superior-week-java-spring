package br.com.vagnereix.dsweek.services;

import br.com.vagnereix.dsweek.dto.GameMinDTO;
import br.com.vagnereix.dsweek.entities.Game;
import br.com.vagnereix.dsweek.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  public List<GameMinDTO> findAll() {
    List<Game> games = gameRepository.findAll();

    List<GameMinDTO> dtoGames = games
      .stream()
      .map(GameMinDTO::fromEntity)
      .toList();

    return dtoGames;
  }
}
