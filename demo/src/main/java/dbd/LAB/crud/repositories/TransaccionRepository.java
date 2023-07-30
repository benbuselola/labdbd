package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Transaccion;
import java.util.List;

public interface TransaccionRepository {
    public Transaccion crear(Transaccion transaccion);
    public List<Transaccion> getAll();
    public Transaccion getTransaccion(int id_transaccion);
    public Transaccion actualizar(Transaccion transaccion);
    public void borrar(int id_transaccion);
}
