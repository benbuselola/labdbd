package dbd.LAB.crud.services;

import dbd.LAB.crud.models.UsuarioCarrito;
import dbd.LAB.crud.repositories.UsuarioCarritoRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioCarritoService {

    private final UsuarioCarritoRepository usuarioCarritoRepository;

    UsuarioCarritoService(@Lazy UsuarioCarritoRepository usuarioCarritoRepository) {
        this.usuarioCarritoRepository = usuarioCarritoRepository;
    }

    // Crear
    @PostMapping("/UsuarioCarrito")
    @ResponseBody
    public UsuarioCarrito crear(@RequestBody UsuarioCarrito usuarioCarrito) {
        UsuarioCarrito resultado = usuarioCarritoRepository.crear(usuarioCarrito);
        return resultado;
    }

    // Leer todos
    @GetMapping("/UsuarioCarrito")
    public List<UsuarioCarrito> getAllUsuarioCarritos() {
        return usuarioCarritoRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/UsuarioCarrito/{id_usuario_carrito}")
    public UsuarioCarrito getUsuarioCarrito(@PathVariable int id_usuario_carrito) {
        return usuarioCarritoRepository.getUsuarioCarrito(id_usuario_carrito);
    }

    // Actualizar por ID
    @PutMapping("/UsuarioCarrito/{id_usuario_carrito}")
    @ResponseBody
    public UsuarioCarrito actualizar(@PathVariable int id_usuario_carrito, @RequestBody UsuarioCarrito usuarioCarrito) {
        usuarioCarrito.setId_usuario_carrito(id_usuario_carrito);
        return usuarioCarritoRepository.actualizar(usuarioCarrito);
    }

    // Borrar por ID
    @DeleteMapping("/UsuarioCarrito/{id_usuario_carrito}")
    public void borrar(@PathVariable int id_usuario_carrito) {
        usuarioCarritoRepository.borrar(id_usuario_carrito);
    }
}
