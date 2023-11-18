package br.com.vagnereix.dsweek.controllers;

import br.com.vagnereix.dsweek.dto.GameMinDTO;
import br.com.vagnereix.dsweek.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping
  public ResponseEntity<List<GameMinDTO>> findAll() {
    List<GameMinDTO> games = gameService.findAll();

    return ResponseEntity.ok().body(games);
  }
}
