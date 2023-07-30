package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CategoriaImp implements CategoriaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Categoria crear(Categoria categoria) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Categoria(id_categoria, categoria) " +
                    "VALUES (:id_categoria, :categoria)";
            conn.createQuery(sql, true)
                    .addParameter("id_categoria", categoria.getId_categoria())
                    .addParameter("categoria", categoria.getCategoria())
                    .executeUpdate();
            return categoria;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Categoria> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Categoria ORDER BY id_categoria ASC")
                    .executeAndFetch(Categoria.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Categoria getCategoria(int id_categoria) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Categoria WHERE id_categoria = :id_categoria")
                    .addParameter("id_categoria", id_categoria)
                    .executeAndFetchFirst(Categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Categoria actualizar(Categoria categoria) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Categoria SET categoria = :categoria WHERE id_categoria = :id_categoria";
            conn.createQuery(sql)
                    .addParameter("categoria", categoria.getCategoria())
                    .addParameter("id_categoria", categoria.getId_categoria())
                    .executeUpdate();
            return categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_categoria) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Categoria WHERE id_categoria = :id_categoria";
            conn.createQuery(sql)
                    .addParameter("id_categoria", id_categoria)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
