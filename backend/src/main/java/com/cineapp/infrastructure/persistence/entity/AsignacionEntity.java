package com.cineapp.infrastructure.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignacion")
public class AsignacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idPelicula;

    private Long idSala;

    private LocalDate fechaPublicacion;

    // Getters

    public Long getId() { return id; }

    public Long getIdPelicula() { return idPelicula; }

    public Long getIdSala() { return idSala; }

    public LocalDate getFechaPublicacion() { return fechaPublicacion; }

    // Setters

    public void setId(Long id) { this.id = id; }

    public void setIdPelicula(Long idPelicula) { this.idPelicula = idPelicula; }

    public void setIdSala(Long idSala) { this.idSala = idSala; }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}