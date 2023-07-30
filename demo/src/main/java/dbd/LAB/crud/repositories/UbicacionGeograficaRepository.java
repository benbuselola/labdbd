package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.UbicacionGeografica;
import java.util.List;

public interface UbicacionGeograficaRepository {
    public UbicacionGeografica crear(UbicacionGeografica ubicacionGeografica);
    public List<UbicacionGeografica> getAll();
    public UbicacionGeografica getUbicacionGeografica(int id_ubicacion);
    public UbicacionGeografica actualizar(UbicacionGeografica ubicacionGeografica);
    public void borrar(int id_ubicacion);
}
