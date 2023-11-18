package br.com.vagnereix.dsweek.services;

import br.com.vagnereix.dsweek.dto.GameDTO;
import br.com.vagnereix.dsweek.dto.GameMinDTO;
import br.com.vagnereix.dsweek.entities.Game;
import br.com.vagnereix.dsweek.projections.GameMinProjection;
import br.com.vagnereix.dsweek.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    List<Game> games = gameRepository.findAll();

    return games
      .stream()
      .map(game ->
        new GameMinDTO(
          game.getId(),
          game.getTitle(),
          game.getYear(),
          game.getImgUrl(),
          game.getShortDescription()
        )
      )
      .toList();
  }

  @Transactional(readOnly = true)
  public GameDTO findById(Long id) {
    Game game = gameRepository.findById(id).get();

    return new GameDTO(
      game.getId(),
      game.getYear(),
      game.getTitle(),
      game.getGenre(),
      game.getPlatforms(),
      game.getScore(),
      game.getImgUrl(),
      game.getShortDescription(),
      game.getLongDescription()
    );
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findByList(Long listId) {
    List<GameMinProjection> games = gameRepository.searchByList(listId);

    return games
      .stream()
      .map(game ->
        new GameMinDTO(
          game.getId(),
          game.getTitle(),
          game.getYear(),
          game.getImgUrl(),
          game.getShortDescription()
        )
      )
      .toList();
  }
}
