package br.com.vagnereix.dsweek.dto;

import br.com.vagnereix.dsweek.entities.Game;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GameMinDTO {

  private Long id;
  private String title;
  private Integer year;
  private String imgUrl;
  private String shortDescription;

  public static GameMinDTO fromEntity(Game game) {
    return GameMinDTO
      .builder()
      .id(game.getId())
      .title(game.getTitle())
      .year(game.getYear())
      .imgUrl(game.getImgUrl())
      .shortDescription(game.getShortDescription())
      .build();
  }
}
