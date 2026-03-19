package com.cineapp.application.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cineapp.application.dto.PeliculaRequestDTO;
import com.cineapp.application.dto.PeliculaResponseDTO;
import com.cineapp.application.service.PeliculaService;
import com.cineapp.domain.model.Pelicula;
import com.cineapp.domain.repository.PeliculaRepository;
import com.cineapp.infrastructure.persistence.entity.PeliculaSalaEntity;
import com.cineapp.infrastructure.persistence.repository.JpaPeliculaRepository;
import com.cineapp.infrastructure.persistence.repository.JpaPeliculaSalaRepository;
import com.cineapp.infrastructure.persistence.repository.JpaSalaRepository;
import com.cineapp.interfaces.exception.ResourceNotFoundException;

/**
 * Servicio de aplicación para Película.
 * Contiene la lógica de negocio y orquesta repositorios.
 */
@Service
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository repository;
    private final JpaPeliculaRepository jpaPeliculaRepository;
    private final JpaPeliculaSalaRepository jpaPeliculaSalaRepository;
    private final JpaSalaRepository jpaSalaRepository;

    public PeliculaServiceImpl(
            PeliculaRepository repository,
            JpaPeliculaRepository jpaPeliculaRepository,
            JpaPeliculaSalaRepository jpaPeliculaSalaRepository,
            JpaSalaRepository jpaSalaRepository
    ) {
        this.repository = repository;
        this.jpaPeliculaRepository = jpaPeliculaRepository;
        this.jpaPeliculaSalaRepository = jpaPeliculaSalaRepository;
        this.jpaSalaRepository = jpaSalaRepository;
    }

    // 🔹 Crear película
    @Override
    public PeliculaResponseDTO crear(PeliculaRequestDTO dto) {
        Pelicula pelicula = new Pelicula(
                null,
                dto.getNombre(),
                dto.getDuracion(),
                true // activa por defecto
        );

        return toResponse(repository.save(pelicula));
    }

    // 🔹 Listar películas
    @Override
    public List<PeliculaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // 🔹 Obtener por ID
    @Override
    public PeliculaResponseDTO obtenerPorId(Long id) {
        Pelicula pelicula = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Película no encontrada"));

        return toResponse(pelicula);
    }

    // *  Actualizar película
    @Override
    public PeliculaResponseDTO actualizar(Long id, PeliculaRequestDTO dto) {

        // Buscar en BD
        Pelicula pelicula = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Película no encontrada"));

        // Actualizar campos
        pelicula.setNombre(dto.getNombre());
        pelicula.setDuracion(dto.getDuracion());

        // Guardar cambios
        return toResponse(repository.save(pelicula));
    }

    // 🔹 Eliminación lógica
    @Override
    public void eliminar(Long id) {
        Pelicula pelicula = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Película no encontrada"));

        pelicula.setActivo(false); // no se borra físicamente
        repository.save(pelicula);
    }

    // 🔹 Mapper dominio → DTO
    private PeliculaResponseDTO toResponse(Pelicula pelicula) {
        PeliculaResponseDTO dto = new PeliculaResponseDTO();
        dto.setId(pelicula.getId());
        dto.setNombre(pelicula.getNombre());
        dto.setDuracion(pelicula.getDuracion());
        return dto;
    }

    // * Buscar por nombre y sala
    @Override
    public List<PeliculaResponseDTO> buscarPorNombreYSala(String nombre, Long idSala) {

        var peliculas = jpaPeliculaRepository.findByNombreContainingIgnoreCase(nombre);

        var relaciones = jpaPeliculaSalaRepository.findByIdSala(idSala);

        if (relaciones.isEmpty()) {
            return List.of();
        }

        var ids = relaciones.stream()
                .map(r -> r.getIdPelicula())
                .filter(id -> id != null)
                .toList();

        return peliculas.stream()
                .filter(p -> p.getId() != null && ids.contains(p.getId()))
                .map(p -> {
                    PeliculaResponseDTO dto = new PeliculaResponseDTO();
                    dto.setId(p.getId());
                    dto.setNombre(p.getNombre());
                    dto.setDuracion(p.getDuracion());
                    return dto;
                })
                .toList();
    }


    // 🔹 Contar por fecha
    @Override
    public long contarPorFecha(String fecha) {
        return jpaPeliculaSalaRepository
                .countByFechaPublicacion(java.time.LocalDate.parse(fecha));
    }

    // 🔹 Obtener por sala
    @Override
    public List<PeliculaResponseDTO> obtenerPorSala(Long idSala) {

        // Obtener relaciones película-sala
        var relaciones = jpaPeliculaSalaRepository.findByIdSala(idSala);

        // Validar si hay datos
        if (relaciones.isEmpty()) {
            throw new ResourceNotFoundException("La sala no tiene películas asignadas");
        }

        return relaciones.stream()
                .map(PeliculaSalaEntity::getIdPelicula)
                .filter(Objects::nonNull)
                .map(id -> {
                    if (id == null) return null;
                    return jpaPeliculaRepository.findById(id).orElse(null);
                })
                .filter(Objects::nonNull)
                .map(p -> {
                    PeliculaResponseDTO dto = new PeliculaResponseDTO();
                    dto.setId(p.getId());
                    dto.setNombre(p.getNombre());
                    dto.setDuracion(p.getDuracion());
                    return dto;
                })
                .toList();
    }

    // 🔹 Obtener por nombre de sala

    @Override
    public List<PeliculaResponseDTO> obtenerPorNombreSala(String nombreSala) {

        var sala = jpaSalaRepository.findByNombreIgnoreCase(nombreSala)
                .orElseThrow(() -> new ResourceNotFoundException("Sala no encontrada"));

        var relaciones = jpaPeliculaSalaRepository.findByIdSala(sala.getId());

        if (relaciones.isEmpty()) {
            throw new ResourceNotFoundException("La sala no tiene películas asignadas");
        }

        return relaciones.stream()
                .map(r -> r.getIdPelicula())
                .filter(Objects::nonNull)
                .map(id -> {
                    if (id == null) return null;
                    return jpaPeliculaRepository.findById(id).orElse(null);
                })
                .filter(Objects::nonNull)
                .map(p -> {
                    PeliculaResponseDTO dto = new PeliculaResponseDTO();
                    dto.setId(p.getId());
                    dto.setNombre(p.getNombre());
                    dto.setDuracion(p.getDuracion());
                    return dto;
                })
                .toList();
    }
}