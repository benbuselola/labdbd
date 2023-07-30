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
    public UbicacionGeografica crear(UbicacionGeografica ubicacionGeografica) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Ubicacion_Geografica(id_ubicacion, pais, id_continente_u) VALUES (:id_ubicacion, :pais, :id_continente_u)";
            conn.createQuery(sql, true)
                    .addParameter("id_ubicacion", ubicacionGeografica.getId_ubicacion())
                    .addParameter("pais", ubicacionGeografica.getPais())
                    .addParameter("id_continente_u", ubicacionGeografica.getId_continente_u())
                    .executeUpdate();
            return ubicacionGeografica;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UbicacionGeografica> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Ubicacion_Geografica ORDER BY id_ubicacion ASC")
                    .executeAndFetch(UbicacionGeografica.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UbicacionGeografica getUbicacionGeografica(int id_ubicacion) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Ubicacion_Geografica WHERE id_ubicacion = :id_ubicacion")
                    .addParameter("id_ubicacion", id_ubicacion)
                    .executeAndFetchFirst(UbicacionGeografica.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UbicacionGeografica actualizar(UbicacionGeografica ubicacionGeografica) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Ubicacion_Geografica SET pais = :pais, id_continente_u = :id_continente_u WHERE id_ubicacion = :id_ubicacion";
            conn.createQuery(sql)
                    .addParameter("pais", ubicacionGeografica.getPais())
                    .addParameter("id_continente_u", ubicacionGeografica.getId_continente_u())
                    .addParameter("id_ubicacion", ubicacionGeografica.getId_ubicacion())
                    .executeUpdate();
            return ubicacionGeografica;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_ubicacion) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Ubicacion_Geografica WHERE id_ubicacion = :id_ubicacion";
            conn.createQuery(sql)
                    .addParameter("id_ubicacion", id_ubicacion)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
