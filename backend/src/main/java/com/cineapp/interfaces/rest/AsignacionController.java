package com.cineapp.interfaces.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineapp.application.service.AsignacionService;
import com.cineapp.infrastructure.persistence.entity.PeliculaSalaEntity;

/**
 * Controlador REST para manejar las asignaciones.
 */
@RestController
@RequestMapping("/api/asignaciones")
@CrossOrigin // Permite llamadas desde Angular
public class AsignacionController {

    private final AsignacionService service;

    public AsignacionController(AsignacionService service) {
        this.service = service;
    }

    // Obtener todas las asignaciones
    @GetMapping
    public List<PeliculaSalaEntity> listar() {
        return service.listar();
    }

    // Crear una nueva asignación
    @PostMapping
    public PeliculaSalaEntity crear(@RequestBody PeliculaSalaEntity asignacion) {

        // Validación básica
        if (asignacion.getIdPelicula() == null || asignacion.getIdSala() == null) {
            throw new RuntimeException("Datos incompletos");
        }

        return service.crear(asignacion);
    }
}