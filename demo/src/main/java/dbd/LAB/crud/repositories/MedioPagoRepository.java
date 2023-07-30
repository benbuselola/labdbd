package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.MedioPago;
import java.util.List;

public interface MedioPagoRepository {
    public MedioPago crear(MedioPago medioPago);
    public List<MedioPago> getAll();
    public MedioPago getMedioPago(int id_medio_pago);
    public MedioPago actualizar(MedioPago medioPago);
    public void borrar(int id_medio_pago);
}
