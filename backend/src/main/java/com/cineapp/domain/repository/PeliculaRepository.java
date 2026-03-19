package com.cineapp.domain.repository;

import java.util.List;
import java.util.Optional;

import com.cineapp.domain.model.Pelicula;

/**
 * Contrato del repositorio en el dominio.
 * Define operaciones sin depender de infraestructura (JPA).
 */
public interface PeliculaRepository {

    Pelicula save(Pelicula pelicula);

    Optional<Pelicula> findById(Long id);

    List<Pelicula> findAll();

    void delete(Long id);
}