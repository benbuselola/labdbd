package dbd.LAB.crud.services;

import dbd.LAB.crud.models.UbicacionGeografica;
import dbd.LAB.crud.repositories.UbicacionGeograficaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UbicacionGeograficaService{

    private final UbicacionGeograficaRepository ubicacionGeograficaRepository;

    UbicacionGeograficaService(@Lazy UbicacionGeograficaRepository UbicacionGeograficaRepository){
        this.ubicacionGeograficaRepository = UbicacionGeograficaRepository;
    }

    @PostMapping("/UbicacionGeografica")
    @ResponseBody
    public UbicacionGeografica crear(@RequestBody UbicacionGeografica ubic){
        return ubicacionGeograficaRepository.crear(ubic);
    }

    @GetMapping("/UbicacionGeografica")
    public List<UbicacionGeografica> getAllUbicaciones(){
        return ubicacionGeograficaRepository.getAll();
    }

    @GetMapping("/UbicacionGeografica/{id_ubicacion}")
    public UbicacionGeografica getUbicacion(@PathVariable int id_ubicacion){
        return ubicacionGeograficaRepository.getUbicacion(id_ubicacion);
    }
}
