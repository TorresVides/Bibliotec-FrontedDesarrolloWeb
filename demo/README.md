# Sistema de Bibliotecas y Libros

Proyecto individual desarrollado con Java, Spring Boot y frontend web.

## Ejecución

Requisitos: Java 17 y Maven.

```bash
./mvnw spring-boot:run
```

En Windows también puede usarse:

```bat
mvnw.cmd spring-boot:run
```

Abrir `http://localhost:8080`. La API está disponible en `http://localhost:8080/bibliotecas`.

## Endpoints

- `POST /bibliotecas`: registra una biblioteca.
- `GET /bibliotecas`: consulta las bibliotecas y sus libros asociados.

## Datos de prueba

Al iniciar, `DatosIniciales` usa los repositorios para crear Biblioteca Central y Biblioteca Norte.
Cada biblioteca guarda una asociación con su libro de prueba.
