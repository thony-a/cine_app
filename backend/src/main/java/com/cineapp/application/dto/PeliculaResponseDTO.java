package com.cineapp.application.dto;

/**
 * DTO de salida para exponer datos de película.
 */
public class PeliculaResponseDTO {

    private Long id;
    private String nombre;
    private Integer duracion;

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Integer getDuracion() { return duracion; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
}