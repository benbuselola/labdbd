package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Carrito;
import java.util.List;

public interface CarritoRepository {
    public Carrito crear(Carrito carrito);
    public List<Carrito> getAll();
    public Carrito getCarrito(int id_carrito);
    public Carrito actualizar(Carrito carrito);
    public void borrar(int id_carrito);
}
