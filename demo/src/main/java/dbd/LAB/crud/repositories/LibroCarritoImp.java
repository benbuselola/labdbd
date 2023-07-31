package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.LibroCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class LibroCarritoImp implements LibroCarritoRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public LibroCarrito crear(LibroCarrito libroCarrito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Libro_Carrito(id_libro_carrito, id_libro_lc, id_carrito_lc) " +
                    "VALUES (:id_libro_carrito, :id_libro_lc, :id_carrito_lc)";
            conn.createQuery(sql, true)
                    .addParameter("id_libro_carrito", libroCarrito.getId_libro_carrito())
                    .addParameter("id_libro_lc", libroCarrito.getId_libro_lc())
                    .addParameter("id_carrito_lc", libroCarrito.getId_carrito_lc())
                    .executeUpdate();
            System.out.println("Elemento agregado correctamente");
            return libroCarrito;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<LibroCarrito> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Libro_Carrito ORDER BY id_libro_carrito ASC")
                    .executeAndFetch(LibroCarrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public LibroCarrito getLibroCarrito(int id_libro_carrito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Libro_Carrito WHERE id_libro_carrito = :id_libro_carrito")
                    .addParameter("id_libro_carrito", id_libro_carrito)
                    .executeAndFetchFirst(LibroCarrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public LibroCarrito actualizar(LibroCarrito libroCarrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Libro_Carrito SET id_libro_lc = :id_libro_lc, id_carrito_lc = :id_carrito_lc " +
                    "WHERE id_libro_carrito = :id_libro_carrito";
            conn.createQuery(sql)
                    .addParameter("id_libro_lc", libroCarrito.getId_libro_lc())
                    .addParameter("id_carrito_lc", libroCarrito.getId_carrito_lc())
                    .addParameter("id_libro_carrito", libroCarrito.getId_libro_carrito())
                    .executeUpdate();
            return libroCarrito;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_libro_carrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Libro_Carrito WHERE id_libro_carrito = :id_libro_carrito";
            conn.createQuery(sql)
                    .addParameter("id_libro_carrito", id_libro_carrito)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
