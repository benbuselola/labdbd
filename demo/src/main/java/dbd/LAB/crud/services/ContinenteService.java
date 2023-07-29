package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Continente;
import dbd.LAB.crud.repositories.ContinenteRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ContinenteService{

    private final ContinenteRepository continenteRepository;

    ContinenteService(@Lazy ContinenteRepository continenteRepository){
        this.continenteRepository = continenteRepository;
    }

    // Crear
    @PostMapping("/Continente")
    @ResponseBody
    public Continente crear(@RequestBody Continente cont){
        Continente resultado = continenteRepository.crear(cont);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Continente")
    public List<Continente> getAllContinentes(){
        return continenteRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Continente/{id_continente}")
    public Continente getContinente(@PathVariable int id_continente){
        return continenteRepository.getContinente(id_continente);
    }
}
