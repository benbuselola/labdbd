package dbd.LAB.crud.services;

import dbd.LAB.crud.models.UsuarioRol;
import dbd.LAB.crud.repositories.UsuarioRolRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioRolService {

    private final UsuarioRolRepository usuarioRolRepository;

    UsuarioRolService(@Lazy UsuarioRolRepository usuarioRolRepository) {
        this.usuarioRolRepository = usuarioRolRepository;
    }

    // Crear
    @PostMapping("/UsuarioRol")
    @ResponseBody
    public UsuarioRol crear(@RequestBody UsuarioRol usuarioRol) {
        UsuarioRol resultado = usuarioRolRepository.crear(usuarioRol);
        return resultado;
    }

    // Leer todos
    @GetMapping("/UsuarioRol")
    public List<UsuarioRol> getAllUsuarioRols() {
        return usuarioRolRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/UsuarioRol/{id_usuario_rol}")
    public UsuarioRol getUsuarioRol(@PathVariable int id_usuario_rol) {
        return usuarioRolRepository.getUsuarioRol(id_usuario_rol);
    }

    // Actualizar por ID
    @PutMapping("/UsuarioRol/{id_usuario_rol}")
    @ResponseBody
    public UsuarioRol actualizar(@PathVariable int id_usuario_rol, @RequestBody UsuarioRol usuarioRol) {
        usuarioRol.setId_usuario_rol(id_usuario_rol);
        return usuarioRolRepository.actualizar(usuarioRol);
    }

    // Borrar por ID
    @DeleteMapping("/UsuarioRol/{id_usuario_rol}")
    public void borrar(@PathVariable int id_usuario_rol) {
        usuarioRolRepository.borrar(id_usuario_rol);
    }
}
