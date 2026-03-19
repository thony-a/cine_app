package com.cineapp.domain.model;

/**
 * Entidad de dominio Sala de cine.
 */
public class Sala {

    private Long id;
    private String nombre;
    private Boolean estado;

    public Sala() {}

    public Sala(Long id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Boolean isEstado() { return estado; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEstado(Boolean estado) { this.estado = estado; }
}