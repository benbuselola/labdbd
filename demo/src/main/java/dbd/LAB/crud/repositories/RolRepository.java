package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Rol;
import java.util.List;

public interface RolRepository {
    public Rol crear(Rol rol);
    public List<Rol> getAll();
    public Rol getRol(int id_rol);
    public Rol actualizar(Rol rol);
    public void borrar(int id_rol);
}
