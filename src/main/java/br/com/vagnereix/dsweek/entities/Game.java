package br.com.vagnereix.dsweek.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_game")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "game_year")
  private Integer year;

  private String title;
  private String genre;
  private String platforms;
  private Double score;
  private String imgUrl;

  @Column(columnDefinition = "TEXT")
  private String shortDescription;

  @Column(columnDefinition = "TEXT")
  private String longDescription;
}
