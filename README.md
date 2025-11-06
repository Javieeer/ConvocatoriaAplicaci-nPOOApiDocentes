# API Docentes - Proyecto Final POO

Este proyecto es una API REST desarrollada con Spring Boot para la gestión de docentes, creada como proyecto final para la materia "Aplicación de Programación Orientada a Objetos".

## Integrantes del Equipo
- Javier Alejandro Zapata Ramos
- Jhonatan Mauricio Rojas Mosquera

## Tecnologías Utilizadas
- Spring Boot 
- Spring Web
- Spring Data JPA
- MySQL Driver
- XAMPP (Para el servidor MySQL y Apache)
- Postman (Para pruebas de API)
- Proyecto desarrollado en SpringToolSuite4

## Características
- Arquitectura REST
- Enfoque Code First para el desarrollo
- Gestión de base de datos MySQL
- CRUD completo para entidad Docentes

## Requisitos Previos
1. Java JDK 17 o superior
2. SpringToolSuite4
3. XAMPP
4. Postman (para pruebas)

## Configuración
1. Clonar el repositorio
2. Iniciar el servidor MySQL y apache mediante XAMPP
3. Configurar las credenciales de base de datos en `application.properties`
4. Ejecutar el proyecto SpringToolSuite4: Click derecho sobre la carpeta del proyecto `Run As` and `4. Spring Boot App`

## Documentación de la API
La API proporciona los siguientes endpoints para la gestión de docentes:
- GET `/api/docentes` - Obtener todos los docentes
- GET `/api/docentes/{id}` - Obtener un docente por ID
- POST `/api/docentes` - Crear un nuevo docente
- PUT `/api/docentes/{id}` - Actualizar un docente existente
- DELETE `/api/docentes/{id}` - Eliminar un docente

## Licencia
Este proyecto es de uso educativo para la Universidad del Tolima.