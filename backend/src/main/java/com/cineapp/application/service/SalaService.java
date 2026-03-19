package com.cineapp.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cineapp.infrastructure.persistence.entity.SalaEntity;
import com.cineapp.infrastructure.persistence.repository.JpaSalaRepository;

@Service // Indica que es un servicio (lógica de negocio)
public class SalaService {

    private final JpaSalaRepository repository;

    public SalaService(JpaSalaRepository repository) {
        this.repository = repository;
    }

    // 🔹 Listar todas las salas
    public List<SalaEntity> listar() {
        return repository.findAll();
    }

    // 🔹 Crear una nueva sala
    public SalaEntity crear(SalaEntity sala) {
        if (sala == null) return null;
        return repository.save(sala);
    }

    // Actualizar una sala existente
    public SalaEntity actualizar(Long id, SalaEntity sala) {

        // Buscar la sala en base de datos
        SalaEntity existente = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Sala no encontrada"));

        // Actualizar campos
        existente.setNombre(sala.getNombre());
        existente.setCapacidad(sala.getCapacidad());
        existente.setDisponible(sala.getDisponible());

        // Guardar cambios
        return repository.save(existente);
    }
}