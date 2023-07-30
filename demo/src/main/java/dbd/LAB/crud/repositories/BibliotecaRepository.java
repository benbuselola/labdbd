package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Biblioteca;
import java.util.List;

public interface BibliotecaRepository {
    public Biblioteca crear(Biblioteca biblioteca);
    public List<Biblioteca> getAll();
    public Biblioteca getBiblioteca(int id_biblioteca);
    public Biblioteca actualizar(Biblioteca biblioteca);
    public void borrar(int id_biblioteca);
}
