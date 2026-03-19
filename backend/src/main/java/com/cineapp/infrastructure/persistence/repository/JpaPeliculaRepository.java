package com.cineapp.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineapp.infrastructure.persistence.entity.PeliculaEntity;

/**
 * Repositorio JPA para la entidad Pelicula.
 */
public interface JpaPeliculaRepository extends JpaRepository<PeliculaEntity, Long> {

    /**
     * Buscar por nombre (case insensitive)
     */
    List<PeliculaEntity> findByNombreContainingIgnoreCase(String nombre);
}