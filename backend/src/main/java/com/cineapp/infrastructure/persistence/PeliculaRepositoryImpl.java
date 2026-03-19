package com.cineapp.infrastructure.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.cineapp.domain.model.Pelicula;
import com.cineapp.domain.repository.PeliculaRepository;
import com.cineapp.infrastructure.persistence.mapper.PeliculaMapper;
import com.cineapp.infrastructure.persistence.repository.JpaPeliculaRepository;

/**
 * Implementación del repositorio del dominio.
 * Adapta JPA a la lógica del dominio.
 */
@Repository
public class PeliculaRepositoryImpl implements PeliculaRepository {

    private final JpaPeliculaRepository jpaRepository;

    public PeliculaRepositoryImpl(JpaPeliculaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        return PeliculaMapper.toDomain(
                jpaRepository.save(PeliculaMapper.toEntity(pelicula))
        );
    }

    @Override
    public Optional<Pelicula> findById(Long id) {
        return jpaRepository.findById(id)
                .map(PeliculaMapper::toDomain);
    }

    @Override
    public List<Pelicula> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(PeliculaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}