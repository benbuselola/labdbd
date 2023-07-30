package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Usuario;
import java.util.List;

public interface UsuarioRepository {
    public Usuario crear(Usuario usuario);
    public List<Usuario> getAll();
    public Usuario getUsuario(int id_usuario);
    public Usuario actualizar(Usuario usuario);
    public void borrar(int id_usuario);
}
