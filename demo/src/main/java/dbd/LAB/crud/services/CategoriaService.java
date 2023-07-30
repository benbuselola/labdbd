package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Categoria;
import dbd.LAB.crud.repositories.CategoriaRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    CategoriaService(@Lazy CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Crear
    @PostMapping("/Categoria")
    @ResponseBody
    public Categoria crear(@RequestBody Categoria categoria) {
        Categoria resultado = categoriaRepository.crear(categoria);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Categoria")
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Categoria/{id_categoria}")
    public Categoria getCategoria(@PathVariable int id_categoria) {
        return categoriaRepository.getCategoria(id_categoria);
    }

    // Actualizar por ID
    @PutMapping("/Categoria/{id_categoria}")
    @ResponseBody
    public Categoria actualizar(@PathVariable int id_categoria, @RequestBody Categoria categoria) {
        categoria.setId_categoria(id_categoria);
        return categoriaRepository.actualizar(categoria);
    }

    // Borrar por ID
    @DeleteMapping("/Categoria/{id_categoria}")
    public void borrar(@PathVariable int id_categoria) {
        categoriaRepository.borrar(id_categoria);
    }
}
