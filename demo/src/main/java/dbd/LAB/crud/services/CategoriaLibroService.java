package dbd.LAB.crud.services;

import dbd.LAB.crud.models.CategoriaLibro;
import dbd.LAB.crud.repositories.CategoriaLibroRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CategoriaLibroService {

    private final CategoriaLibroRepository categoriaLibroRepository;

    CategoriaLibroService(@Lazy CategoriaLibroRepository categoriaLibroRepository) {
        this.categoriaLibroRepository = categoriaLibroRepository;
    }

    // Crear
    @PostMapping("/CategoriaLibro")
    @ResponseBody
    public CategoriaLibro crear(@RequestBody CategoriaLibro categoriaLibro) {
        CategoriaLibro resultado = categoriaLibroRepository.crear(categoriaLibro);
        return resultado;
    }

    // Leer todos
    @GetMapping("/CategoriaLibro")
    public List<CategoriaLibro> getAllCategoriaLibros() {
        return categoriaLibroRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/CategoriaLibro/{id_categoria_libro}")
    public CategoriaLibro getCategoriaLibro(@PathVariable int id_categoria_libro) {
        return categoriaLibroRepository.getCategoriaLibro(id_categoria_libro);
    }

    // Actualizar por ID
    @PutMapping("/CategoriaLibro/{id_categoria_libro}")
    @ResponseBody
    public CategoriaLibro actualizar(@PathVariable int id_categoria_libro, @RequestBody CategoriaLibro categoriaLibro) {
        categoriaLibro.setId_categoria_libro(id_categoria_libro);
        return categoriaLibroRepository.actualizar(categoriaLibro);
    }

    // Borrar por ID
    @DeleteMapping("/CategoriaLibro/{id_categoria_libro}")
    public void borrar(@PathVariable int id_categoria_libro) {
        categoriaLibroRepository.borrar(id_categoria_libro);
    }
}
