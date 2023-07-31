package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.LibroFavorito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class LibroFavoritoImp implements LibroFavoritoRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public LibroFavorito crear(LibroFavorito libroFavorito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Libro_Favorito(id_libro_favorito, id_usuario_f, id_libro_f) VALUES (:id_libro_favorito, :id_usuario_f, :id_libro_f)";
            conn.createQuery(sql, true)
                    .addParameter("id_libro_favorito", libroFavorito.getId_libro_favorito())
                    .addParameter("id_usuario_f", libroFavorito.getId_usuario_f())
                    .addParameter("id_libro_f", libroFavorito.getId_libro_f())
                    .executeUpdate();
            return libroFavorito;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<LibroFavorito> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Libro_Favorito ORDER BY id_libro_favorito ASC")
                    .executeAndFetch(LibroFavorito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public LibroFavorito getLibroFavorito(int id_libro_favorito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Libro_Favorito WHERE id_libro_favorito = :id_libro_favorito")
                    .addParameter("id_libro_favorito", id_libro_favorito)
                    .executeAndFetchFirst(LibroFavorito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public LibroFavorito actualizar(LibroFavorito libroFavorito) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Libro_Favorito SET id_usuario_f = :id_usuario_f, id_libro_f = :id_libro_f WHERE id_libro_favorito = :id_libro_favorito";
            conn.createQuery(sql)
                    .addParameter("id_usuario_f", libroFavorito.getId_usuario_f())
                    .addParameter("id_libro_f", libroFavorito.getId_libro_f())
                    .addParameter("id_libro_favorito", libroFavorito.getId_libro_favorito())
                    .executeUpdate();
            return libroFavorito;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_libro_favorito) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Libro_Favorito WHERE id_libro_favorito = :id_libro_favorito";
            conn.createQuery(sql)
                    .addParameter("id_libro_favorito", id_libro_favorito)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
