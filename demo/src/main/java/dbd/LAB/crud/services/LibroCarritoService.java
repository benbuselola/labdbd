package dbd.LAB.crud.services;

import dbd.LAB.crud.models.LibroCarrito;
import dbd.LAB.crud.repositories.LibroCarritoRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LibroCarritoService {

    private final LibroCarritoRepository libroCarritoRepository;

    LibroCarritoService(@Lazy LibroCarritoRepository libroCarritoRepository) {
        this.libroCarritoRepository = libroCarritoRepository;
    }

    // Crear
    @PostMapping("/LibroCarrito")
    @ResponseBody
    public LibroCarrito crear(@RequestBody LibroCarrito libroCarrito) {
        LibroCarrito resultado = libroCarritoRepository.crear(libroCarrito);
        return resultado;
    }

    // Leer todos
    @GetMapping("/LibroCarrito")
    public List<LibroCarrito> getAllLibroCarritos() {
        return libroCarritoRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/LibroCarrito/{id_libro_carrito}")
    public LibroCarrito getLibroCarrito(@PathVariable int id_libro_carrito) {
        return libroCarritoRepository.getLibroCarrito(id_libro_carrito);
    }

    // Actualizar por ID
    @PutMapping("/LibroCarrito/{id_libro_carrito}")
    @ResponseBody
    public LibroCarrito actualizar(@PathVariable int id_libro_carrito, @RequestBody LibroCarrito libroCarrito) {
        libroCarrito.setId_libro_carrito(id_libro_carrito);
        return libroCarritoRepository.actualizar(libroCarrito);
    }

    // Borrar por ID
    @DeleteMapping("/LibroCarrito/{id_libro_carrito}")
    public void borrar(@PathVariable int id_libro_carrito) {
        libroCarritoRepository.borrar(id_libro_carrito);
    }
}
