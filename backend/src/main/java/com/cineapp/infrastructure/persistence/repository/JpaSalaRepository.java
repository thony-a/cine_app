package com.cineapp.infrastructure.persistence.repository;

import com.cineapp.infrastructure.persistence.entity.SalaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio JPA para Sala.
 */
public interface JpaSalaRepository extends JpaRepository<SalaEntity, Long> {

    /**
     * Buscar sala por nombre
     */
    Optional<SalaEntity> findByNombreIgnoreCase(String nombre);
}