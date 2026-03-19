package com.cineapp.interfaces.rest;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cineapp.application.service.SalaService;
import com.cineapp.infrastructure.persistence.entity.SalaEntity;

@RestController // Indica que es un controlador REST (devuelve JSON)
@RequestMapping("/api/salas") // Ruta base para todas las operaciones de salas
public class SalaController {

    private final SalaService service;

    // Inyección de dependencia del servicio (capa de aplicación)
    public SalaController(SalaService service) {
        this.service = service;
    }

    // 🔹 Obtener todas las salas
    @GetMapping
    public List<SalaEntity> listar() {
        return service.listar();
    }

    // 🔹 Crear una nueva sala
    @PostMapping
    public SalaEntity crear(@RequestBody SalaEntity sala) {
        return service.crear(sala);
    }

    // 🔥 Actualizar una sala existente
    @PutMapping("/{id}")
    public SalaEntity actualizar(@PathVariable Long id, @RequestBody SalaEntity sala) {
        // id → viene por URL
        // sala → viene en el body (JSON)
        return service.actualizar(id, sala);
    }
}