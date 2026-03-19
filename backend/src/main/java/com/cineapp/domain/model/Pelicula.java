package com.cineapp.domain.model;

/**
 * Entidad de dominio Pelicula.
 * Representa la lógica del negocio sin dependencias externas.
 */
public class Pelicula {

    private Long id;
    private String nombre;
    private Integer duracion;
    private boolean activo;

    public Pelicula() {}

    public Pelicula(Long id, String nombre, Integer duracion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.activo = activo;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Integer getDuracion() { return duracion; }
    public boolean isActivo() { return activo; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
    public void setActivo(boolean activo) { this.activo = activo; }
}