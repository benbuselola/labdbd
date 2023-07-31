package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Biblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class BibliotecaImp implements BibliotecaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Biblioteca crear(Biblioteca biblioteca) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Biblioteca(id_biblioteca, id_usuario_B, id_libro_B, visualizacion) VALUES (:id_biblioteca, :id_usuario_B, :id_libro_B, :visualizacion)";
            conn.createQuery(sql, true)
                    .addParameter("id_biblioteca", biblioteca.getId_biblioteca())
                    .addParameter("id_usuario_B", biblioteca.getId_usuario_B())
                    .addParameter("id_libro_B", biblioteca.getId_libro_B())
                    .addParameter("visualizacion", biblioteca.isVisualizacion())
                    .executeUpdate();
            System.out.println("Elemento agregado correctamente");
            return biblioteca;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Biblioteca> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Biblioteca ORDER BY id_biblioteca ASC")
                    .executeAndFetch(Biblioteca.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Biblioteca getBiblioteca(int id_biblioteca) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Biblioteca WHERE id_biblioteca = :id_biblioteca")
                    .addParameter("id_biblioteca", id_biblioteca)
                    .executeAndFetchFirst(Biblioteca.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Biblioteca actualizar(Biblioteca biblioteca) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Biblioteca SET id_usuario_B = :id_usuario_B, id_libro_B = :id_libro_B, visualizacion = :visualizacion WHERE id_biblioteca = :id_biblioteca";
            conn.createQuery(sql)
                    .addParameter("id_usuario_B", biblioteca.getId_usuario_B())
                    .addParameter("id_libro_B", biblioteca.getId_libro_B())
                    .addParameter("visualizacion", biblioteca.isVisualizacion())
                    .addParameter("id_biblioteca", biblioteca.getId_biblioteca())
                    .executeUpdate();
            return biblioteca;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_biblioteca) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Biblioteca WHERE id_biblioteca = :id_biblioteca";
            conn.createQuery(sql)
                    .addParameter("id_biblioteca", id_biblioteca)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
