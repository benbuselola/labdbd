package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Libro;
import java.util.List;

public interface LibroRepository {
    public Libro crear(Libro libro);
    public List<Libro> getAll();
    public Libro getLibro(int id_libro);
    public Libro actualizar(Libro libro);
    public void borrar(int id_libro);
}
