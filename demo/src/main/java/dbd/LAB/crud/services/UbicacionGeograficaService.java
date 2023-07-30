package dbd.LAB.crud.services;

import dbd.LAB.crud.models.UbicacionGeografica;
import dbd.LAB.crud.repositories.UbicacionGeograficaRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UbicacionGeograficaService {

    private final UbicacionGeograficaRepository ubicacionGeograficaRepository;

    UbicacionGeograficaService(@Lazy UbicacionGeograficaRepository ubicacionGeograficaRepository) {
        this.ubicacionGeograficaRepository = ubicacionGeograficaRepository;
    }

    // Crear
    @PostMapping("/UbicacionGeografica")
    @ResponseBody
    public UbicacionGeografica crear(@RequestBody UbicacionGeografica ubicacionGeografica) {
        UbicacionGeografica resultado = ubicacionGeograficaRepository.crear(ubicacionGeografica);
        return resultado;
    }

    // Leer todos
    @GetMapping("/UbicacionGeografica")
    public List<UbicacionGeografica> getAllUbicacionGeograficas() {
        return ubicacionGeograficaRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/UbicacionGeografica/{id_ubicacion}")
    public UbicacionGeografica getUbicacionGeografica(@PathVariable int id_ubicacion) {
        return ubicacionGeograficaRepository.getUbicacionGeografica(id_ubicacion);
    }

    // Actualizar por ID
    @PutMapping("/UbicacionGeografica/{id_ubicacion}")
    @ResponseBody
    public UbicacionGeografica actualizar(@PathVariable int id_ubicacion, @RequestBody UbicacionGeografica ubicacionGeografica) {
        ubicacionGeografica.setId_ubicacion(id_ubicacion);
        return ubicacionGeograficaRepository.actualizar(ubicacionGeografica);
    }

    // Borrar por ID
    @DeleteMapping("/UbicacionGeografica/{id_ubicacion}")
    public void borrar(@PathVariable int id_ubicacion) {
        ubicacionGeograficaRepository.borrar(id_ubicacion);
    }
}
