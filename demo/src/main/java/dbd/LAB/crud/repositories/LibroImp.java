package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class LibroImp implements LibroRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Libro crear(Libro libro) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Libro(id_libro, autor, nombre_libro, precio, stock_libro, cantidad_ventas, valoracion_media, cantidad_favorito, id_ubicacion_libro, id_restriccion_libro) VALUES (:id_libro, :autor, :nombre_libro, :precio, :stock_libro, :cantidad_ventas, :valoracion_media, :cantidad_favorito, :id_ubicacion_libro, :id_restriccion_libro)";
            conn.createQuery(sql, true)
                    .addParameter("id_libro", libro.getId_libro())
                    .addParameter("autor", libro.getAutor())
                    .addParameter("nombre_libro", libro.getNombre_libro())
                    .addParameter("precio", libro.getPrecio())
                    .addParameter("stock_libro", libro.getStock_libro())
                    .addParameter("cantidad_ventas", libro.getCantidad_ventas())
                    .addParameter("valoracion_media", libro.getValoracion_media())
                    .addParameter("cantidad_favorito", libro.getCantidad_favorito())
                    .addParameter("id_ubicacion_libro", libro.getId_ubicacion_libro())
                    .addParameter("id_restriccion_libro", libro.getId_restriccion_libro())
                    .executeUpdate();
            return libro;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Libro> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Libro ORDER BY id_libro ASC")
                    .executeAndFetch(Libro.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Libro getLibro(int id_libro) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Libro WHERE id_libro = :id_libro")
                    .addParameter("id_libro", id_libro)
                    .executeAndFetchFirst(Libro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Libro actualizar(Libro libro) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Libro SET autor = :autor, nombre_libro = :nombre_libro, precio = :precio, stock_libro = :stock_libro, cantidad_ventas = :cantidad_ventas, valoracion_media = :valoracion_media, cantidad_favorito = :cantidad_favorito, id_ubicacion_libro = :id_ubicacion_libro, id_restriccion_libro = :id_restriccion_libro WHERE id_libro = :id_libro";
            conn.createQuery(sql)
                    .addParameter("autor", libro.getAutor())
                    .addParameter("nombre_libro", libro.getNombre_libro())
                    .addParameter("precio", libro.getPrecio())
                    .addParameter("stock_libro", libro.getStock_libro())
                    .addParameter("cantidad_ventas", libro.getCantidad_ventas())
                    .addParameter("valoracion_media", libro.getValoracion_media())
                    .addParameter("cantidad_favorito", libro.getCantidad_favorito())
                    .addParameter("id_ubicacion_libro", libro.getId_ubicacion_libro())
                    .addParameter("id_restriccion_libro", libro.getId_restriccion_libro())
                    .addParameter("id_libro", libro.getId_libro())
                    .executeUpdate();
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_libro) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Libro WHERE id_libro = :id_libro";
            conn.createQuery(sql)
                    .addParameter("id_libro", id_libro)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
