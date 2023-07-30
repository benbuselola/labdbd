package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.LibroCarrito;
import java.util.List;

public interface LibroCarritoRepository {
    public LibroCarrito crear(LibroCarrito libroCarrito);
    public List<LibroCarrito> getAll();
    public LibroCarrito getLibroCarrito(int id_libro_carrito);
    public LibroCarrito actualizar(LibroCarrito libroCarrito);
    public void borrar(int id_libro_carrito);
}
