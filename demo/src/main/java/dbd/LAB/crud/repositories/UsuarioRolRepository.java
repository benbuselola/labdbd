package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.UsuarioRol;
import java.util.List;

public interface UsuarioRolRepository {
    public UsuarioRol crear(UsuarioRol usuarioRol);
    public List<UsuarioRol> getAll();
    public UsuarioRol getUsuarioRol(int id_usuario_rol);
    public UsuarioRol actualizar(UsuarioRol usuarioRol);
    public void borrar(int id_usuario_rol);
}
