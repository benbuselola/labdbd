package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Categoria;
import java.util.List;

public interface CategoriaRepository {
    public Categoria crear(Categoria categoria);
    public List<Categoria> getAll();
    public Categoria getCategoria(int id_categoria);
    public Categoria actualizar(Categoria categoria);
    public void borrar(int id_categoria);
}
