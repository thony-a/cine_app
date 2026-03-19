package com.cineapp.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa una sala de cine.
 * Se mapea a la tabla "sala_cine" en la base de datos.
 */
@Entity
@Table(name = "sala_cine")
public class SalaEntity {

    // Identificador único (clave primaria)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre de la sala
    private String nombre;

    // Capacidad de la sala (número de asientos)
    private Integer capacidad;

    // Indica si la sala está disponible
    private Boolean disponible;

    // ===== Getters =====

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    // ===== Setters =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}