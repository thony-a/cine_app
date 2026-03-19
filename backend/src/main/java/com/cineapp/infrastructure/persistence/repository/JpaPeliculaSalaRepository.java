package com.cineapp.infrastructure.persistence.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cineapp.infrastructure.persistence.entity.PeliculaSalaEntity;

/**
 * Repositorio JPA para la relación película-sala.
 */
public interface JpaPeliculaSalaRepository extends JpaRepository<PeliculaSalaEntity, Long> {

    /**
     * Buscar relaciones por ID de sala.
     */
    List<PeliculaSalaEntity> findByIdSala(Long idSala);

    /**
     * Buscar relaciones por fecha de publicación.
     */
    List<PeliculaSalaEntity> findByFechaPublicacion(LocalDate fecha);

    /**
     * Contar registros por fecha (alternativa simple).
     */
    long countByFechaPublicacion(LocalDate fecha);

    /**
     * Usar función SQL definida en la base de datos.
     */
    @Query(value = "SELECT contar_peliculas_por_fecha(:fecha)", nativeQuery = true)
    int contarPeliculasPorFecha(@Param("fecha") LocalDate fecha);
    
}