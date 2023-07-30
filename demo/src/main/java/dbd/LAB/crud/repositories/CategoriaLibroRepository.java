package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.CategoriaLibro;
import java.util.List;

public interface CategoriaLibroRepository {
    public CategoriaLibro crear(CategoriaLibro categoriaLibro);
    public List<CategoriaLibro> getAll();
    public CategoriaLibro getCategoriaLibro(int id_categoria_libro);
    public CategoriaLibro actualizar(CategoriaLibro categoriaLibro);
    public void borrar(int id_categoria_libro);
}
