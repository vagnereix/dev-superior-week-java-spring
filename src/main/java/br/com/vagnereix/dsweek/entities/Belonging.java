package br.com.vagnereix.dsweek.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_belonging")
public class Belonging {

  @EmbeddedId
  private BelongingPK id = new BelongingPK();

  private Integer position;

  public Belonging(Game game, GameList list, Integer position) {
    id.setGame(game);
    id.setList(list);
    this.position = position;
  }
}
