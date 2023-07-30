package dbd.LAB.crud.services;

import dbd.LAB.crud.models.LibroFavorito;
import dbd.LAB.crud.repositories.LibroFavoritoRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LibroFavoritoService {

    private final LibroFavoritoRepository libroFavoritoRepository;

    LibroFavoritoService(@Lazy LibroFavoritoRepository libroFavoritoRepository) {
        this.libroFavoritoRepository = libroFavoritoRepository;
    }

    // Crear
    @PostMapping("/LibroFavorito")
    @ResponseBody
    public LibroFavorito crear(@RequestBody LibroFavorito libroFavorito) {
        LibroFavorito resultado = libroFavoritoRepository.crear(libroFavorito);
        return resultado;
    }

    // Leer todos
    @GetMapping("/LibroFavorito")
    public List<LibroFavorito> getAllLibrosFavoritos() {
        return libroFavoritoRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/LibroFavorito/{id_libro_favorito}")
    public LibroFavorito getLibroFavorito(@PathVariable int id_libro_favorito) {
        return libroFavoritoRepository.getLibroFavorito(id_libro_favorito);
    }

    // Actualizar por ID
    @PutMapping("/LibroFavorito/{id_libro_favorito}")
    @ResponseBody
    public LibroFavorito actualizar(@PathVariable int id_libro_favorito, @RequestBody LibroFavorito libroFavorito) {
        libroFavorito.setId_libro_favorito(id_libro_favorito);
        return libroFavoritoRepository.actualizar(libroFavorito);
    }

    // Borrar por ID
    @DeleteMapping("/LibroFavorito/{id_libro_favorito}")
    public void borrar(@PathVariable int id_libro_favorito) {
        libroFavoritoRepository.borrar(id_libro_favorito);
    }
}
