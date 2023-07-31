package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Restriccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RestriccionImp implements RestriccionRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Restriccion crear(Restriccion restriccion) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Restriccion(id_restriccion, edad) VALUES (:id_restriccion, :edad)";
            conn.createQuery(sql, true)
                    .addParameter("id_restriccion", restriccion.getId_restriccion())
                    .addParameter("edad", restriccion.getEdad())
                    .executeUpdate();
            System.out.println("Elemento agregado correctamente");
            return restriccion;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Restriccion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Restriccion ORDER BY id_restriccion ASC")
                    .executeAndFetch(Restriccion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Restriccion getRestriccion(int id_restriccion) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Restriccion WHERE id_restriccion = :id_restriccion")
                    .addParameter("id_restriccion", id_restriccion)
                    .executeAndFetchFirst(Restriccion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Restriccion actualizar(Restriccion restriccion) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Restriccion SET edad = :edad WHERE id_restriccion = :id_restriccion";
            conn.createQuery(sql)
                    .addParameter("edad", restriccion.getEdad())
                    .addParameter("id_restriccion", restriccion.getId_restriccion())
                    .executeUpdate();
            return restriccion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_restriccion) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Restriccion WHERE id_restriccion = :id_restriccion";
            conn.createQuery(sql)
                    .addParameter("id_restriccion", id_restriccion)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
