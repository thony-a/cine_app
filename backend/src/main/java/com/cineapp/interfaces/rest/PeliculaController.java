package com.cineapp.interfaces.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cineapp.application.dto.PeliculaRequestDTO;
import com.cineapp.application.dto.PeliculaResponseDTO;
import com.cineapp.application.service.PeliculaService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

/**
 * Controlador REST para gestionar películas.
 */
@SecurityRequirement(name = "bearerAuth") //
@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    // Crear película
    @PostMapping
    public PeliculaResponseDTO crear(@Valid @RequestBody PeliculaRequestDTO dto) {
        return service.crear(dto);
    }

    // Listar todas las películas
    @GetMapping
    public List<PeliculaResponseDTO> listar() {
        return service.listar();
    }

    // Obtener película por ID
    @GetMapping("/{id}")
    public PeliculaResponseDTO obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // Actualizar película
    @PutMapping("/{id}")
    public PeliculaResponseDTO actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PeliculaRequestDTO dto
    ) {
        return service.actualizar(id, dto);
    }

    // Eliminación lógica
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    // Buscar películas por nombre y sala
    @GetMapping("/buscar")
    public List<PeliculaResponseDTO> buscar(
            @RequestParam String nombre,
            @RequestParam Long idSala
    ) {
        return service.buscarPorNombreYSala(nombre, idSala);
    }

    
    // Contar películas por fecha
    @GetMapping("/conteo")
    public long contar(@RequestParam String fecha) {
        return service.contarPorFecha(fecha);
    }

    // Obtener películas por sala
    @GetMapping("/sala/{idSala}")
    public List<PeliculaResponseDTO> porSala(@PathVariable Long idSala) {
        return service.obtenerPorSala(idSala);
    }

    // Obtener películas por nombre de sala
    @GetMapping("/sala-nombre")
    public List<PeliculaResponseDTO> porNombreSala(@RequestParam String nombre) {
        return service.obtenerPorNombreSala(nombre);
    }
}