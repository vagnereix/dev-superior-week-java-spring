package br.com.vagnereix.dsweek.dto;

public record GameMinDTO(
  Long id,
  String title,
  Integer year,
  String imgUrl,
  String shortDescription
) {}
