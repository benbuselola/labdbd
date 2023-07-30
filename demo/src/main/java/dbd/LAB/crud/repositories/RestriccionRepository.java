package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Restriccion;
import java.util.List;

public interface RestriccionRepository {
    public Restriccion crear(Restriccion restriccion);
    public List<Restriccion> getAll();
    public Restriccion getRestriccion(int id_restriccion);
    public Restriccion actualizar(Restriccion restriccion);
    public void borrar(int id_restriccion);
}
