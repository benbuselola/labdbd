package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Transaccion;
import dbd.LAB.crud.repositories.TransaccionRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;

    TransaccionService(@Lazy TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    // Crear
    @PostMapping("/Transaccion")
    @ResponseBody
    public Transaccion crear(@RequestBody Transaccion transaccion) {
        Transaccion resultado = transaccionRepository.crear(transaccion);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Transaccion")
    public List<Transaccion> getAllTransacciones() {
        return transaccionRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Transaccion/{id_transaccion}")
    public Transaccion getTransaccion(@PathVariable int id_transaccion) {
        return transaccionRepository.getTransaccion(id_transaccion);
    }

    // Actualizar por ID
    @PutMapping("/Transaccion/{id_transaccion}")
    @ResponseBody
    public Transaccion actualizar(@PathVariable int id_transaccion, @RequestBody Transaccion transaccion) {
        transaccion.setId_transaccion(id_transaccion);
        return transaccionRepository.actualizar(transaccion);
    }

    // Borrar por ID
    @DeleteMapping("/Transaccion/{id_transaccion}")
    public void borrar(@PathVariable int id_transaccion) {
        transaccionRepository.borrar(id_transaccion);
    }
}
