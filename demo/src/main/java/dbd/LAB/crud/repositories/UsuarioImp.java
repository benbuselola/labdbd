package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UsuarioImp implements UsuarioRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Usuario crear(Usuario usuario) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Usuario(id_usuario, nombre_usuario, contraseña, fecha_nacimiento, mail, id_ubicacion_usuario) VALUES (:id_usuario, :nombre_usuario, :contraseña, :fecha_nacimiento, :mail, :id_ubicacion_usuario)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", usuario.getId_usuario())
                    .addParameter("nombre_usuario", usuario.getNombre_usuario())
                    .addParameter("contraseña", usuario.getContraseña())
                    .addParameter("fecha_nacimiento", usuario.getFecha_nacimiento())
                    .addParameter("mail", usuario.getMail())
                    .addParameter("id_ubicacion_usuario", usuario.getId_ubicacion_usuario())
                    .executeUpdate();
            return usuario;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario ORDER BY id_usuario ASC")
                    .executeAndFetch(Usuario.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario getUsuario(int id_usuario) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario WHERE id_usuario = :id_usuario")
                    .addParameter("id_usuario", id_usuario)
                    .executeAndFetchFirst(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Usuario SET nombre_usuario = :nombre_usuario, contraseña = :contraseña, fecha_nacimiento = :fecha_nacimiento, mail = :mail, id_ubicacion_usuario = :id_ubicacion_usuario WHERE id_usuario = :id_usuario";
            conn.createQuery(sql)
                    .addParameter("nombre_usuario", usuario.getNombre_usuario())
                    .addParameter("contraseña", usuario.getContraseña())
                    .addParameter("fecha_nacimiento", usuario.getFecha_nacimiento())
                    .addParameter("mail", usuario.getMail())
                    .addParameter("id_ubicacion_usuario", usuario.getId_ubicacion_usuario())
                    .addParameter("id_usuario", usuario.getId_usuario())
                    .executeUpdate();
            return usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Usuario WHERE id_usuario = :id_usuario";
            conn.createQuery(sql)
                    .addParameter("id_usuario", id_usuario)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
