package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.CategoriaLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CategoriaLibroImp implements CategoriaLibroRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public CategoriaLibro crear(CategoriaLibro categoriaLibro) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Categoria_Libro(id_categoria_libro, id_libro_cl, id_categoria_cl) " +
                    "VALUES (:id_categoria_libro, :id_libro_cl, :id_categoria_cl)";
            conn.createQuery(sql, true)
                    .addParameter("id_categoria_libro", categoriaLibro.getId_categoria_libro())
                    .addParameter("id_libro_cl", categoriaLibro.getId_libro_cl())
                    .addParameter("id_categoria_cl", categoriaLibro.getId_categoria_cl())
                    .executeUpdate();
            return categoriaLibro;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<CategoriaLibro> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Categoria_Libro ORDER BY id_categoria_libro ASC")
                    .executeAndFetch(CategoriaLibro.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public CategoriaLibro getCategoriaLibro(int id_categoria_libro) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Categoria_Libro WHERE id_categoria_libro = :id_categoria_libro")
                    .addParameter("id_categoria_libro", id_categoria_libro)
                    .executeAndFetchFirst(CategoriaLibro.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public CategoriaLibro actualizar(CategoriaLibro categoriaLibro) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Categoria_Libro SET id_libro_cl = :id_libro_cl, id_categoria_cl = :id_categoria_cl " +
                    "WHERE id_categoria_libro = :id_categoria_libro";
            conn.createQuery(sql)
                    .addParameter("id_libro_cl", categoriaLibro.getId_libro_cl())
                    .addParameter("id_categoria_cl", categoriaLibro.getId_categoria_cl())
                    .addParameter("id_categoria_libro", categoriaLibro.getId_categoria_libro())
                    .executeUpdate();
            return categoriaLibro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_categoria_libro) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Categoria_Libro WHERE id_categoria_libro = :id_categoria_libro";
            conn.createQuery(sql)
                    .addParameter("id_categoria_libro", id_categoria_libro)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
