package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.LibroFavorito;
import java.util.List;

public interface LibroFavoritoRepository {
    public LibroFavorito crear(LibroFavorito libroFavorito);
    public List<LibroFavorito> getAll();
    public LibroFavorito getLibroFavorito(int id_libro_favorito);
    public LibroFavorito actualizar(LibroFavorito libroFavorito);
    public void borrar(int id_libro_favorito);
}
