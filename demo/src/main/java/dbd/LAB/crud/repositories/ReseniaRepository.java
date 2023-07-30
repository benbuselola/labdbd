package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Resenia;
import java.util.List;

public interface ReseniaRepository {
    public Resenia crear(Resenia resenia);
    public List<Resenia> getAll();
    public Resenia getResenia(int id_reseña);
    public Resenia actualizar(Resenia resenia);
    public void borrar(int id_reseña);
}
