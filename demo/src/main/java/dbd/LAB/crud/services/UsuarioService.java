package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Usuario;
import dbd.LAB.crud.repositories.UsuarioRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    UsuarioService(@Lazy UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Crear
    @PostMapping("/Usuario")
    @ResponseBody
    public Usuario crear(@RequestBody Usuario usuario) {
        Usuario resultado = usuarioRepository.crear(usuario);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Usuario")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Usuario/{id_usuario}")
    public Usuario getUsuario(@PathVariable int id_usuario) {
        return usuarioRepository.getUsuario(id_usuario);
    }

    // Actualizar por ID
    @PutMapping("/Usuario/{id_usuario}")
    @ResponseBody
    public Usuario actualizar(@PathVariable int id_usuario, @RequestBody Usuario usuario) {
        usuario.setId_usuario(id_usuario);
        return usuarioRepository.actualizar(usuario);
    }

    // Borrar por ID
    @DeleteMapping("/Usuario/{id_usuario}")
    public void borrar(@PathVariable int id_usuario) {
        usuarioRepository.borrar(id_usuario);
    }
}
