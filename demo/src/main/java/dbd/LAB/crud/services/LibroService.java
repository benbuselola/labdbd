package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Libro;
import dbd.LAB.crud.repositories.LibroRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LibroService {

    private final LibroRepository libroRepository;

    LibroService(@Lazy LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Crear
    @PostMapping("/Libro")
    @ResponseBody
    public Libro crear(@RequestBody Libro libro) {
        Libro resultado = libroRepository.crear(libro);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Libro")
    public List<Libro> getAllLibros() {
        return libroRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Libro/{id_libro}")
    public Libro getLibro(@PathVariable int id_libro) {
        return libroRepository.getLibro(id_libro);
    }

    // Actualizar por ID
    @PutMapping("/Libro/{id_libro}")
    @ResponseBody
    public Libro actualizar(@PathVariable int id_libro, @RequestBody Libro libro) {
        libro.setId_libro(id_libro);
        return libroRepository.actualizar(libro);
    }

    // Borrar por ID
    @DeleteMapping("/Libro/{id_libro}")
    public void borrar(@PathVariable int id_libro) {
        libroRepository.borrar(id_libro);
    }
}
