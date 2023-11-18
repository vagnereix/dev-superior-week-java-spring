package br.com.vagnereix.dsweek.controllers;

import br.com.vagnereix.dsweek.dto.GameListDTO;
import br.com.vagnereix.dsweek.dto.GameMinDTO;
import br.com.vagnereix.dsweek.dto.ReplacementDTO;
import br.com.vagnereix.dsweek.services.GameListService;
import br.com.vagnereix.dsweek.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lists")
public class GameListController {

  @Autowired
  private GameService gameService;

  @Autowired
  private GameListService gameListService;

  @GetMapping
  public ResponseEntity<List<GameListDTO>> findAll() {
    List<GameListDTO> lists = gameListService.findAll();

    return ResponseEntity.ok().body(lists);
  }

  @GetMapping("/{listId}/games")
  public ResponseEntity<List<GameMinDTO>> findByList(
    @PathVariable Long listId
  ) {
    List<GameMinDTO> lists = gameService.findByList(listId);

    return ResponseEntity.ok().body(lists);
  }

  @PostMapping("/{listId}/replacement")
  public ResponseEntity<Void> move(
    @PathVariable Long listId,
    @RequestBody ReplacementDTO replacementDTO
  ) {
    gameListService.move(
      listId,
      replacementDTO.sourceIndex(),
      replacementDTO.destinationIndex()
    );

    return ResponseEntity.noContent().build();
  }
}
