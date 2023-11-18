package br.com.vagnereix.dsweek.services;

import br.com.vagnereix.dsweek.dto.GameListDTO;
import br.com.vagnereix.dsweek.entities.GameList;
import br.com.vagnereix.dsweek.repositories.GameListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {

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
}
