package com.cineapp.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para recibir datos de entrada en creación o actualización.
 */
public class PeliculaRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "La duración es obligatoria")
    private Integer duracion;

    public String getNombre() { return nombre; }
    public Integer getDuracion() { return duracion; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
}