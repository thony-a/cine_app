package com.cineapp.infrastructure.persistence.mapper;

import com.cineapp.domain.model.Pelicula;
import com.cineapp.infrastructure.persistence.entity.PeliculaEntity;

/**
 * Mapper manual entre entidad JPA y modelo de dominio.
 */
public class PeliculaMapper {

    public static Pelicula toDomain(PeliculaEntity entity) {
        if (entity == null) return null;

        return new Pelicula(
                entity.getId(),
                entity.getNombre(),
                entity.getDuracion(),
                entity.isActivo()
        );
    }

    public static PeliculaEntity toEntity(Pelicula domain) {
        if (domain == null) return null;

        PeliculaEntity entity = new PeliculaEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setDuracion(domain.getDuracion());
        entity.setActivo(domain.isActivo());

        return entity;
    }
}