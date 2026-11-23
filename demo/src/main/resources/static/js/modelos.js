// Modelo JavaScript del objeto Biblioteca recibido desde la API.
class BibliotecaModelo {
  constructor({ id = null, nombre = "", direccion = "", ciudad = "", libros = [] }) {
    this.id = id;
    this.nombre = nombre;
    this.direccion = direccion;
    this.ciudad = ciudad;
    this.libros = libros.map((libro) => new LibroModelo(libro));
  }
}

// Modelo JavaScript del objeto Libro recibido dentro de cada Biblioteca.
class LibroModelo {
  constructor({ id = null, titulo = "", autor = "", anioPublicacion = null }) {
    this.id = id;
    this.titulo = titulo;
    this.autor = autor;
    this.anioPublicacion = anioPublicacion;
  }
}
