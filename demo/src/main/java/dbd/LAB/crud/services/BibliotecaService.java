package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Biblioteca;
import dbd.LAB.crud.repositories.BibliotecaRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    BibliotecaService(@Lazy BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    // Crear
    @PostMapping("/Biblioteca")
    @ResponseBody
    public Biblioteca crear(@RequestBody Biblioteca biblioteca) {
        Biblioteca resultado = bibliotecaRepository.crear(biblioteca);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Biblioteca")
    public List<Biblioteca> getAllBibliotecas() {
        return bibliotecaRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Biblioteca/{id_biblioteca}")
    public Biblioteca getBiblioteca(@PathVariable int id_biblioteca) {
        return bibliotecaRepository.getBiblioteca(id_biblioteca);
    }

    // Actualizar por ID
    @PutMapping("/Biblioteca/{id_biblioteca}")
    @ResponseBody
    public Biblioteca actualizar(@PathVariable int id_biblioteca, @RequestBody Biblioteca biblioteca) {
        biblioteca.setId_biblioteca(id_biblioteca);
        return bibliotecaRepository.actualizar(biblioteca);
    }

    // Borrar por ID
    @DeleteMapping("/Biblioteca/{id_biblioteca}")
    public void borrar(@PathVariable int id_biblioteca) {
        bibliotecaRepository.borrar(id_biblioteca);
    }
}
