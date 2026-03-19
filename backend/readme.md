# Cine App - Backend API (Spring Boot)

API REST desarrollada en **Java Spring Boot** para la gestión de un sistema de cine, incluyendo películas, salas y asignaciones, aplicando buenas prácticas de arquitectura, seguridad y acceso a datos.

---

# Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security (JWT)
* PostgreSQL
* Swagger (OpenAPI)
* Maven

---

# Arquitectura

Estructura basada en **DDD + Hexagonal**:

```
com.cineapp
│
├── application
│   ├── dto        # Entrada/salida de datos (API)
│   └── service    # Casos de uso / lógica de aplicación
│
├── domain
│   └── model      # Entidades de negocio (sin frameworks)
│
├── infrastructure
│   ├── config     # Seguridad, JWT, Swagger, CORS
│   ├── persistence
│   │   ├── entity     # Entidades JPA (BD)
│   │   └── repository # Acceso a datos (JPA)
│   └── rest       # Controllers (endpoints)
```

✔ Separación de capas
✔ Bajo acoplamiento
✔ Escalable y mantenible

---

# Funcionalidades

## Películas

* Crear película
* Listar películas
* Obtener por ID
* Actualizar película
* Eliminación lógica

---

## Salas

* Crear sala
* Listar salas
* Actualizar sala

Campos:

* nombre
* capacidad
* disponible

---

## Asignaciones (Película - Sala)

* Crear asignación
* Listar asignaciones
* Relación entre película y sala
* Manejo de fechas

Campos:

* idPelicula
* idSala
* fechaPublicacion
* fechaFin (opcional)
* activo

---

# Endpoints principales

## Películas

```
GET    /api/peliculas
POST   /api/peliculas
PUT    /api/peliculas/{id}
DELETE /api/peliculas/{id}
```

---

## Salas

```
GET  /api/salas
POST /api/salas
PUT  /api/salas/{id}
```

---

## Asignaciones

```
GET  /api/asignaciones
POST /api/asignaciones
```

---

# Consultas implementadas

## Buscar película por nombre y sala

```
GET /api/peliculas/buscar
```

---

## Contar películas por fecha

```
GET /api/peliculas/conteo?fecha=YYYY-MM-DD
```

---

## Buscar películas por nombre de sala

```
GET /api/peliculas/sala-nombre?nombre=Sala 1
```

---

# Seguridad (JWT)

Autenticación stateless mediante token.

## Login

```
POST /auth/login
```

### Body:

```json
{
  "username": "admin",
  "password": "1234"
}
```

---

## Uso del token

```
Authorization: Bearer TU_TOKEN
```

---

# Documentación (Swagger)

Disponible en:

```
http://localhost:8080/swagger-ui/index.html
```

---

# Base de datos

Motor: **PostgreSQL**

## Tablas

* pelicula
* sala_cine
* pelicula_sala_cine

---

# Configuración

Archivo:

```
application.yml
```

Incluye:

* Conexión a base de datos
* Configuración de seguridad
* Parámetros del sistema

---

# Manejo de errores

* Validaciones en servicios y controladores
* Uso de excepciones controladas
* Respuestas estructuradas

---

# DTOs

* Request DTO
* Response DTO
* Separación entre capas

---

# Eliminación lógica

Se usa:

```
activo = true/false
```

✔ No se eliminan registros físicamente

---

# Ejecución

```bash
mvn clean install -DskipTests
mvn spring-boot:run
```

---

# Usuario de prueba

```
username: admin
password: 1234
```

---

# Estado del proyecto

✔ Backend funcional
✔ CRUD completo (películas, salas, asignaciones)
✔ Integración con frontend Angular
✔ Arquitectura DDD implementada
✔ Seguridad con JWT
✔ Endpoints operativos

---

# Autor

Anthony Palma
