package com.cineapp.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA para persistencia.
 * Representa la tabla 'pelicula' en la base de datos.
 */
@Entity
@Table(name = "pelicula")
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer duracion;

    @Column(nullable = false)
    private boolean activo = true;

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Integer getDuracion() { return duracion; }
    public boolean isActivo() { return activo; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
    public void setActivo(boolean activo) { this.activo = activo; }
}