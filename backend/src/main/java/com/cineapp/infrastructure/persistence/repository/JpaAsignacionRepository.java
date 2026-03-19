package com.cineapp.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineapp.infrastructure.persistence.entity.AsignacionEntity;

public interface JpaAsignacionRepository extends JpaRepository<AsignacionEntity, Long> {
}