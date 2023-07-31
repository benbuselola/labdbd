package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Continente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ContinenteImp implements ContinenteRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Continente crear(Continente continente) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Continente(id_continente, continente) VALUES (:id_continente, :continente)";
            conn.createQuery(sql, true)
                    .addParameter("id_continente", continente.getId_continente())
                    .addParameter("continente", continente.getContinente())
                    .executeUpdate();
            System.out.println("Elemento agregado correctamente");
            return continente;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Continente> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Continente ORDER BY id_continente ASC")
                    .executeAndFetch(Continente.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Continente getContinente(int id_continente) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Continente WHERE id_continente = :id_continente")
                    .addParameter("id_continente", id_continente)
                    .executeAndFetchFirst(Continente.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Continente actualizar(Continente continente) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Continente SET continente = :continente WHERE id_continente = :id_continente";
            conn.createQuery(sql)
                    .addParameter("continente", continente.getContinente())
                    .addParameter("id_continente", continente.getId_continente())
                    .executeUpdate();
            return continente;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_continente) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Continente WHERE id_continente = :id_continente";
            conn.createQuery(sql)
                    .addParameter("id_continente", id_continente)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
