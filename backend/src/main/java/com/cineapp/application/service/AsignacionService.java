package com.cineapp.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cineapp.infrastructure.persistence.entity.PeliculaSalaEntity;
import com.cineapp.infrastructure.persistence.repository.JpaPeliculaSalaRepository;

/**
 * Servicio para manejar la lógica de negocio de asignaciones (película-sala).
 */
@Service
public class AsignacionService {

    private final JpaPeliculaSalaRepository repository;

    public AsignacionService(JpaPeliculaSalaRepository repository) {
        this.repository = repository;
    }

    // Listar todas las asignaciones
    public List<PeliculaSalaEntity> listar() {
        return repository.findAll();
    }

    // Crear una nueva asignación
    public PeliculaSalaEntity crear(PeliculaSalaEntity asignacion) {

        // Validación básica
        if (asignacion.getIdPelicula() == null || asignacion.getIdSala() == null) {
            throw new RuntimeException("Película y sala son obligatorias");
        }

        // Asignar fecha actual si no viene desde frontend
        if (asignacion.getFechaPublicacion() == null) {
            asignacion.setFechaPublicacion(LocalDate.now());
        }

        // Estado activo por defecto
        asignacion.setActivo(true);

        return repository.save(asignacion);
    }
}