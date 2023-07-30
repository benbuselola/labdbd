package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Restriccion;
import dbd.LAB.crud.repositories.RestriccionRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RestriccionService {

    private final RestriccionRepository restriccionRepository;

    RestriccionService(@Lazy RestriccionRepository restriccionRepository) {
        this.restriccionRepository = restriccionRepository;
    }

    // Crear
    @PostMapping("/Restriccion")
    @ResponseBody
    public Restriccion crear(@RequestBody Restriccion restriccion) {
        Restriccion resultado = restriccionRepository.crear(restriccion);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Restriccion")
    public List<Restriccion> getAllRestricciones() {
        return restriccionRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Restriccion/{id_restriccion}")
    public Restriccion getRestriccion(@PathVariable int id_restriccion) {
        return restriccionRepository.getRestriccion(id_restriccion);
    }

    // Actualizar por ID
    @PutMapping("/Restriccion/{id_restriccion}")
    @ResponseBody
    public Restriccion actualizar(@PathVariable int id_restriccion, @RequestBody Restriccion restriccion) {
        restriccion.setId_restriccion(id_restriccion);
        return restriccionRepository.actualizar(restriccion);
    }

    // Borrar por ID
    @DeleteMapping("/Restriccion/{id_restriccion}")
    public void borrar(@PathVariable int id_restriccion) {
        restriccionRepository.borrar(id_restriccion);
    }
}
