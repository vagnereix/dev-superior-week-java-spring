package br.com.vagnereix.dsweek.projections;

public interface GameMinProjection {
  Long getId();
  String getTitle();
  Integer getGameYear();
  String getImgUrl();
  String getShortDescription();
  Integer getPosition();
}
