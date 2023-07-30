package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.MedioPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class MedioPagoImp implements MedioPagoRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public MedioPago crear(MedioPago medioPago) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Medio_Pago(id_medio_pago, medio_pago) VALUES (:id_medio_pago, :medio_pago)";
            conn.createQuery(sql, true)
                    .addParameter("id_medio_pago", medioPago.getId_medio_pago())
                    .addParameter("medio_pago", medioPago.getMedio_pago())
                    .executeUpdate();
            return medioPago;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<MedioPago> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Medio_Pago ORDER BY id_medio_pago ASC")
                    .executeAndFetch(MedioPago.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public MedioPago getMedioPago(int id_medio_pago) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Medio_Pago WHERE id_medio_pago = :id_medio_pago")
                    .addParameter("id_medio_pago", id_medio_pago)
                    .executeAndFetchFirst(MedioPago.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public MedioPago actualizar(MedioPago medioPago) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Medio_Pago SET medio_pago = :medio_pago WHERE id_medio_pago = :id_medio_pago";
            conn.createQuery(sql)
                    .addParameter("medio_pago", medioPago.getMedio_pago())
                    .addParameter("id_medio_pago", medioPago.getId_medio_pago())
                    .executeUpdate();
            return medioPago;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_medio_pago) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Medio_Pago WHERE id_medio_pago = :id_medio_pago";
            conn.createQuery(sql)
                    .addParameter("id_medio_pago", id_medio_pago)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
