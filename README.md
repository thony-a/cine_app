# CineApp

Aplicación web full-stack para la gestión de películas, salas de cine y asignaciones.

## Arquitectura

El sistema está dividido en dos componentes principales:

* **Backend:** API REST desarrollada con Spring Boot
* **Frontend:** Aplicación SPA desarrollada con Angular

Ambos componentes se comunican mediante HTTP (JSON).

---

## Tecnologías

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Maven
* MySQL / SQLite (según configuración)

### Frontend

* Angular
* TypeScript
* Bootstrap

---

## Funcionalidades

* Autenticación básica
* Gestión de películas (CRUD)
* Gestión de salas (CRUD)
* Asignación de películas a salas
* Dashboard con métricas

---

## Estructura del Proyecto

```
cine_app/
│
├── backend/      # API REST (Spring Boot)
├── frontend/     # Aplicación Angular
└── README.md
```

---

## Ejecución del Proyecto

### 1. Backend

```bash
cd backend
mvn spring-boot:run
```

Servidor disponible en:

```
http://localhost:8080
```

---

### 2. Frontend

```bash
cd frontend
npm install
ng serve
```

Aplicación disponible en:

```
http://localhost:4200
```

---

## Endpoints principales

* `/api/peliculas`
* `/api/salas`
* `/api/asignaciones`
* `/api/auth`

---

## Flujo básico de uso

1. Iniciar sesión
2. Crear salas
3. Crear películas
4. Asignar películas a salas
5. Visualizar datos en el dashboard

---

## Notas

* El backend debe estar en ejecución antes de iniciar el frontend
* Configurar correctamente `environment.ts` con la URL del backend

---

## Estado del proyecto

* Backend funcional
* Frontend funcional
* Integración completa

---

## Documentación adicional

Cada módulo contiene su propia documentación:

* `backend/README.md` → detalles técnicos del backend
* `frontend/README.md` → detalles del frontend

---

## Autor

Desarrollado como proyecto de práctica en desarrollo full-stack
