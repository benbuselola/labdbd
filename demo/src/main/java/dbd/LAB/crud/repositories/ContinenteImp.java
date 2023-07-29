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
    public Continente crear(Continente cont) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO continente(id_continente,continente)" +
                    "VALUES (:id_continente,:continente)";
            conn.createQuery(sql, true)
                    .addParameter("id_continente", cont.getId_continente())
                    .addParameter("continente", cont.getContinente())
                    .executeUpdate();
            return cont;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Continente> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from continente order by id_continente asc")
                    .executeAndFetch(Continente.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Continente getContinente(int id_continente) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from continente where id_continente = :id_continente")
                    .addParameter("id_continente", id_continente)
                    .executeAndFetchFirst(Continente.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
