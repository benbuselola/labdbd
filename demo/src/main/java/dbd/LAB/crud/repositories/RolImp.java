package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RolImp implements RolRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Rol crear(Rol rol) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Rol(id_rol, nombre_rol) VALUES (:id_rol, :nombre_rol)";
            conn.createQuery(sql, true)
                    .addParameter("id_rol", rol.getId_rol())
                    .addParameter("nombre_rol", rol.getNombre_rol())
                    .executeUpdate();
            return rol;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Rol> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Rol ORDER BY id_rol ASC")
                    .executeAndFetch(Rol.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Rol getRol(int id_rol) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Rol WHERE id_rol = :id_rol")
                    .addParameter("id_rol", id_rol)
                    .executeAndFetchFirst(Rol.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Rol actualizar(Rol rol) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Rol SET nombre_rol = :nombre_rol WHERE id_rol = :id_rol";
            conn.createQuery(sql)
                    .addParameter("nombre_rol", rol.getNombre_rol())
                    .addParameter("id_rol", rol.getId_rol())
                    .executeUpdate();
            return rol;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_rol) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Rol WHERE id_rol = :id_rol";
            conn.createQuery(sql)
                    .addParameter("id_rol", id_rol)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
