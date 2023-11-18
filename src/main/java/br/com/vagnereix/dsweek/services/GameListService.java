package br.com.vagnereix.dsweek.services;

import br.com.vagnereix.dsweek.dto.GameListDTO;
import br.com.vagnereix.dsweek.entities.GameList;
import br.com.vagnereix.dsweek.projections.GameMinProjection;
import br.com.vagnereix.dsweek.repositories.GameListRepository;
import br.com.vagnereix.dsweek.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {

  @Autowired
  private GameRepository gameRepository;

  @Autowired
  private GameListRepository gameListRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> lists = gameListRepository.findAll();

    return lists
      .stream()
      .map(list -> new GameListDTO(list.getId(), list.getName()))
      .toList();
  }

  @Transactional
  public void move(Long listId, int sourceIndex, int destinationIndex) {
    List<GameMinProjection> games = gameRepository.searchByList(listId);

    GameMinProjection game = games.remove(sourceIndex);
    games.add(destinationIndex, game);

    int min = Math.min(sourceIndex, destinationIndex);
    int max = Math.max(sourceIndex, destinationIndex);

    for (int currentIndex = min; currentIndex <= max; currentIndex++) {
      gameListRepository.updateBelongingPosition(
        listId,
        games.get(currentIndex).getId(),
        currentIndex
      );
    }
  }
}
