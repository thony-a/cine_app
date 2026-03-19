-- ========================================
-- TABLAS
-- ========================================

CREATE TABLE IF NOT EXISTS pelicula (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    duracion INT NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS sala_cine (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    estado BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS pelicula_sala_cine (
    id SERIAL PRIMARY KEY,
    id_pelicula INT NOT NULL,
    id_sala INT NOT NULL,
    fecha_publicacion DATE NOT NULL,
    fecha_fin DATE,
    activo BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_pelicula
        FOREIGN KEY (id_pelicula) REFERENCES pelicula(id),

    CONSTRAINT fk_sala
        FOREIGN KEY (id_sala) REFERENCES sala_cine(id)
);

-- ========================================
-- DATOS INICIALES (OPCIONAL PERO RECOMENDADO)
-- ========================================

INSERT INTO pelicula (nombre, duracion)
VALUES ('Batman', 120);

INSERT INTO sala_cine (nombre, estado)
VALUES ('Sala 1', true);

INSERT INTO pelicula_sala_cine (id_pelicula, id_sala, fecha_publicacion, activo)
VALUES (1, 1, CURRENT_DATE, true);

-- ========================================
-- FUNCIÓN REQUERIDA
-- ========================================

CREATE OR REPLACE FUNCTION contar_peliculas_por_fecha(fecha_param DATE)
RETURNS INTEGER AS $$
BEGIN
    RETURN (
        SELECT COUNT(*)
        FROM pelicula_sala_cine
        WHERE fecha_publicacion = fecha_param
        AND activo = true
    );
END;
$$ LANGUAGE plpgsql;