package com.cineapp.application.service;

import java.util.List;

import com.cineapp.application.dto.PeliculaRequestDTO;
import com.cineapp.application.dto.PeliculaResponseDTO;

/**
 * Servicio de aplicación para manejar lógica de negocio de Pelicula.
 */
public interface PeliculaService {

    PeliculaResponseDTO crear(PeliculaRequestDTO dto);

    List<PeliculaResponseDTO> listar();

    PeliculaResponseDTO obtenerPorId(Long id);

    PeliculaResponseDTO actualizar(Long id, PeliculaRequestDTO dto);

    void eliminar(Long id);

    List<PeliculaResponseDTO> buscarPorNombreYSala(String nombre, Long idSala);

    long contarPorFecha(String fecha);

    List<PeliculaResponseDTO> obtenerPorSala(Long idSala);

    List<PeliculaResponseDTO> obtenerPorNombreSala(String nombreSala);
}