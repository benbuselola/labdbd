package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.UsuarioCarrito;
import java.util.List;

public interface UsuarioCarritoRepository {
    public UsuarioCarrito crear(UsuarioCarrito usuarioCarrito);
    public List<UsuarioCarrito> getAll();
    public UsuarioCarrito getUsuarioCarrito(int id_usuario_carrito);
    public UsuarioCarrito actualizar(UsuarioCarrito usuarioCarrito);
    public void borrar(int id_usuario_carrito);
}
