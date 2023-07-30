package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Rol;
import dbd.LAB.crud.repositories.RolRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RolService {

    private final RolRepository rolRepository;

    RolService(@Lazy RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    // Crear
    @PostMapping("/Rol")
    @ResponseBody
    public Rol crear(@RequestBody Rol rol) {
        Rol resultado = rolRepository.crear(rol);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Rol")
    public List<Rol> getAllRoles() {
        return rolRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Rol/{id_rol}")
    public Rol getRol(@PathVariable int id_rol) {
        return rolRepository.getRol(id_rol);
    }

    // Actualizar por ID
    @PutMapping("/Rol/{id_rol}")
    @ResponseBody
    public Rol actualizar(@PathVariable int id_rol, @RequestBody Rol rol) {
        rol.setId_rol(id_rol);
        return rolRepository.actualizar(rol);
    }

    // Borrar por ID
    @DeleteMapping("/Rol/{id_rol}")
    public void borrar(@PathVariable int id_rol) {
        rolRepository.borrar(id_rol);
    }
}
