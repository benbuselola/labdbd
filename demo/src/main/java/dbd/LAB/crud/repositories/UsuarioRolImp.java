package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UsuarioRolImp implements UsuarioRolRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public UsuarioRol crear(UsuarioRol usuarioRol) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Usuario_Rol(id_usuario_rol, id_usuario_ur, id_rol_ur) " +
                    "VALUES (:id_usuario_rol, :id_usuario_ur, :id_rol_ur)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario_rol", usuarioRol.getId_usuario_rol())
                    .addParameter("id_usuario_ur", usuarioRol.getId_usuario_ur())
                    .addParameter("id_rol_ur", usuarioRol.getId_rol_ur())
                    .executeUpdate();
            System.out.println("Elemento agregado correctamente");
            return usuarioRol;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UsuarioRol> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario_Rol ORDER BY id_usuario_rol ASC")
                    .executeAndFetch(UsuarioRol.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UsuarioRol getUsuarioRol(int id_usuario_rol) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario_Rol WHERE id_usuario_rol = :id_usuario_rol")
                    .addParameter("id_usuario_rol", id_usuario_rol)
                    .executeAndFetchFirst(UsuarioRol.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UsuarioRol actualizar(UsuarioRol usuarioRol) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Usuario_Rol SET id_usuario_ur = :id_usuario_ur, id_rol_ur = :id_rol_ur " +
                    "WHERE id_usuario_rol = :id_usuario_rol";
            conn.createQuery(sql)
                    .addParameter("id_usuario_ur", usuarioRol.getId_usuario_ur())
                    .addParameter("id_rol_ur", usuarioRol.getId_rol_ur())
                    .addParameter("id_usuario_rol", usuarioRol.getId_usuario_rol())
                    .executeUpdate();
            return usuarioRol;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_usuario_rol) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Usuario_Rol WHERE id_usuario_rol = :id_usuario_rol";
            conn.createQuery(sql)
                    .addParameter("id_usuario_rol", id_usuario_rol)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
