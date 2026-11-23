package com.example.demo.Configuracion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Entidades.Biblioteca;
import com.example.demo.Entidades.Libro;
import com.example.demo.Repositorios.BibliotecaRepository;
import com.example.demo.Repositorios.LibroRepository;

// Configuración que carga datos reales de prueba mediante los repositorios.
@Configuration
public class DatosIniciales {

    @Bean
    CommandLineRunner cargarDatos(
            BibliotecaRepository bibliotecaRepository,
            LibroRepository libroRepository) {
        return args -> {
            if (bibliotecaRepository.count() > 0) {
                return;
            }

            Biblioteca central = new Biblioteca();
            central.setNombre("Biblioteca Central");
            central.setDireccion("Carrera 10 # 20-30");
            central.setCiudad("Bogotá");

            Biblioteca norte = new Biblioteca();
            norte.setNombre("Biblioteca Norte");
            norte.setDireccion("Avenida Norte 45");
            norte.setCiudad("Bogotá");

            Libro cienAnos = new Libro();
            cienAnos.setTitulo("Cien años de soledad");
            cienAnos.setAutor("Gabriel García Márquez");
            cienAnos.setAnioPublicacion(1967);
            cienAnos.setBiblioteca(central);

            Libro coronel = new Libro();
            coronel.setTitulo("El coronel no tiene quien le escriba");
            coronel.setAutor("Gabriel García Márquez");
            coronel.setAnioPublicacion(1961);
            coronel.setBiblioteca(norte);

            central.getLibros().add(cienAnos);
            norte.getLibros().add(coronel);

            bibliotecaRepository.save(central);
            bibliotecaRepository.save(norte);
            libroRepository.save(cienAnos);
            libroRepository.save(coronel);
        };
    }
}
