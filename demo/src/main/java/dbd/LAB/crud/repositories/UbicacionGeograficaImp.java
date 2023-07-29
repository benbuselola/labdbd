package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.UbicacionGeografica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UbicacionGeograficaImp implements UbicacionGeograficaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public UbicacionGeografica crear(UbicacionGeografica ubicacion) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO ubicacion_geografica(id_ubicacion, pais, id_continente_u)" +
                    "VALUES (:id_ubicacion, :pais, :id_continente_u)";
            conn.createQuery(sql, true)
                    .addParameter("id_ubicacion", ubicacion.getId_ubicacion())
                    .addParameter("pais", ubicacion.getPais())
                    .addParameter("id_continente_u", ubicacion.getId_continente_u())
                    .executeUpdate();
            return ubicacion;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<UbicacionGeografica> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from ubicacion_geografica order by id_ubicacion asc")
                    .executeAndFetch(UbicacionGeografica.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UbicacionGeografica getUbicacion(int id_ubicacion) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from ubicacion_geografica where id_ubicacion = :id_ubicacion")
                    .addParameter("id_ubicacion", id_ubicacion)
                    .executeAndFetchFirst(UbicacionGeografica.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

