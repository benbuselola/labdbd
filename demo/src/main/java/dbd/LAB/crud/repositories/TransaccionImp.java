package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TransaccionImp implements TransaccionRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Transaccion crear(Transaccion transaccion) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Transaccion(id_transaccion, fecha_boleta, id_pago, id_carro) " +
                    "VALUES (:id_transaccion, :fecha_boleta, :id_pago, :id_carro)";
            conn.createQuery(sql, true)
                    .addParameter("id_transaccion", transaccion.getId_transaccion())
                    .addParameter("fecha_boleta", transaccion.getFecha_boleta())
                    .addParameter("id_pago", transaccion.getId_pago())
                    .addParameter("id_carro", transaccion.getId_carro())
                    .executeUpdate();
            System.out.println("Elemento agregado correctamente");
            return transaccion;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Transaccion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Transaccion ORDER BY id_transaccion ASC")
                    .executeAndFetch(Transaccion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Transaccion getTransaccion(int id_transaccion) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Transaccion WHERE id_transaccion = :id_transaccion")
                    .addParameter("id_transaccion", id_transaccion)
                    .executeAndFetchFirst(Transaccion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Transaccion actualizar(Transaccion transaccion) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Transaccion SET fecha_boleta = :fecha_boleta, id_pago = :id_pago, id_carro = :id_carro " +
                    "WHERE id_transaccion = :id_transaccion";
            conn.createQuery(sql)
                    .addParameter("fecha_boleta", transaccion.getFecha_boleta())
                    .addParameter("id_pago", transaccion.getId_pago())
                    .addParameter("id_carro", transaccion.getId_carro())
                    .addParameter("id_transaccion", transaccion.getId_transaccion())
                    .executeUpdate();
            return transaccion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_transaccion) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Transaccion WHERE id_transaccion = :id_transaccion";
            conn.createQuery(sql)
                    .addParameter("id_transaccion", id_transaccion)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
