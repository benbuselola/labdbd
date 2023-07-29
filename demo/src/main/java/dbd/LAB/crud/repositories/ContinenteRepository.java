package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Continente;
import java.util.List;

public interface ContinenteRepository {
    public Continente crear(Continente continente );
    public List<Continente> getAll();
    public Continente getContinente(int id_continente);
}
