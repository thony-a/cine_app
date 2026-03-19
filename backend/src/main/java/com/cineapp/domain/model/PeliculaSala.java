package com.cineapp.domain.model;

import java.time.LocalDate;

/**
 * Relación entre película y sala.
 */
public class PeliculaSala {

    private Long id;
    private Long idPelicula;
    private Long idSala;
    private LocalDate fechaPublicacion;
    private LocalDate fechaFin;
    private boolean activo;

    public PeliculaSala() {}

    public PeliculaSala(Long id, Long idPelicula, Long idSala,
                        LocalDate fechaPublicacion, LocalDate fechaFin, boolean activo) {
        this.id = id;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaFin = fechaFin;
        this.activo = activo;
    }

    public Long getId() { return id; }
    public Long getIdPelicula() { return idPelicula; }
    public Long getIdSala() { return idSala; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public LocalDate getFechaFin() { return fechaFin; }
    public boolean isActivo() { return activo; }

    public void setId(Long id) { this.id = id; }
    public void setIdPelicula(Long idPelicula) { this.idPelicula = idPelicula; }
    public void setIdSala(Long idSala) { this.idSala = idSala; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public void setActivo(boolean activo) { this.activo = activo; }
}