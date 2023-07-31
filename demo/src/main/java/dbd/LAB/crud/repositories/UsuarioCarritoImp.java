package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.UsuarioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UsuarioCarritoImp implements UsuarioCarritoRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public UsuarioCarrito crear(UsuarioCarrito usuarioCarrito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Usuario_Carrito(id_usuario_carrito, id_usuario_uc, id_carrito_uc) " +
                    "VALUES (:id_usuario_carrito, :id_usuario_uc, :id_carrito_uc)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario_carrito", usuarioCarrito.getId_usuario_carrito())
                    .addParameter("id_usuario_uc", usuarioCarrito.getId_usuario_uc())
                    .addParameter("id_carrito_uc", usuarioCarrito.getId_carrito_uc())
                    .executeUpdate();
            System.out.println("Elemento agregado correctamente");
            return usuarioCarrito;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UsuarioCarrito> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario_Carrito ORDER BY id_usuario_carrito ASC")
                    .executeAndFetch(UsuarioCarrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UsuarioCarrito getUsuarioCarrito(int id_usuario_carrito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario_Carrito WHERE id_usuario_carrito = :id_usuario_carrito")
                    .addParameter("id_usuario_carrito", id_usuario_carrito)
                    .executeAndFetchFirst(UsuarioCarrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UsuarioCarrito actualizar(UsuarioCarrito usuarioCarrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Usuario_Carrito SET id_usuario_uc = :id_usuario_uc, id_carrito_uc = :id_carrito_uc " +
                    "WHERE id_usuario_carrito = :id_usuario_carrito";
            conn.createQuery(sql)
                    .addParameter("id_usuario_uc", usuarioCarrito.getId_usuario_uc())
                    .addParameter("id_carrito_uc", usuarioCarrito.getId_carrito_uc())
                    .addParameter("id_usuario_carrito", usuarioCarrito.getId_usuario_carrito())
                    .executeUpdate();
            return usuarioCarrito;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_usuario_carrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Usuario_Carrito WHERE id_usuario_carrito = :id_usuario_carrito";
            conn.createQuery(sql)
                    .addParameter("id_usuario_carrito", id_usuario_carrito)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
