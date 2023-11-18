package br.com.vagnereix.dsweek.dto;

public record GameDTO(
  Long id,
  Integer year,
  String title,
  String genre,
  String platforms,
  Double score,
  String imgUrl,
  String shortDescription,
  String longDescription
) {}
