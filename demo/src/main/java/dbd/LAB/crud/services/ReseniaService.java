package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Resenia;
import dbd.LAB.crud.repositories.ReseniaRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ReseniaService {

    private final ReseniaRepository reseniaRepository;

    ReseniaService(@Lazy ReseniaRepository reseniaRepository) {
        this.reseniaRepository = reseniaRepository;
    }

    // Crear
    @PostMapping("/Resenia")
    @ResponseBody
    public Resenia crear(@RequestBody Resenia resenia) {
        Resenia resultado = reseniaRepository.crear(resenia);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Resenia")
    public List<Resenia> getAllResenias() {
        return reseniaRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Resenia/{id_reseña}")
    public Resenia getResenia(@PathVariable int id_reseña) {
        return reseniaRepository.getResenia(id_reseña);
    }

    // Actualizar por ID
    @PutMapping("/Resenia/{id_reseña}")
    @ResponseBody
    public Resenia actualizar(@PathVariable int id_reseña, @RequestBody Resenia resenia) {
        resenia.setId_reseña(id_reseña);
        return reseniaRepository.actualizar(resenia);
    }

    // Borrar por ID
    @DeleteMapping("/Resenia/{id_reseña}")
    public void borrar(@PathVariable int id_reseña) {
        reseniaRepository.borrar(id_reseña);
    }
}
