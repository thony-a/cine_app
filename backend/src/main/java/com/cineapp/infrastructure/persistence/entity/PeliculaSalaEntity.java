package com.cineapp.infrastructure.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa la relación entre película y sala.
 */
@Entity
@Table(name = "pelicula_sala_cine")
public class PeliculaSalaEntity {

    // Identificador único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Referencia a película
    private Long idPelicula;

    // Referencia a sala
    private Long idSala;

    // Fecha de inicio de la proyección
    private LocalDate fechaPublicacion;

    // Fecha de fin (opcional)
    private LocalDate fechaFin;

    // Estado lógico
    private boolean activo = true;

    // Getters

    public Long getId() { return id; }
    public Long getIdPelicula() { return idPelicula; }
    public Long getIdSala() { return idSala; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public LocalDate getFechaFin() { return fechaFin; }
    public boolean isActivo() { return activo; }

    // Setters

    public void setId(Long id) { this.id = id; }
    public void setIdPelicula(Long idPelicula) { this.idPelicula = idPelicula; }
    public void setIdSala(Long idSala) { this.idSala = idSala; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public void setActivo(boolean activo) { this.activo = activo; }
}