package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Resenia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ReseniaImp implements ReseniaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Resenia crear(Resenia resenia) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Reseña(id_reseña, comentario_reseña, valoracion, id_usuarioR, id_librore) " +
                    "VALUES (:id_reseña, :comentario_reseña, :valoracion, :id_usuarioR, :id_librore)";
            conn.createQuery(sql, true)
                    .addParameter("id_reseña", resenia.getId_reseña())
                    .addParameter("comentario_reseña", resenia.getComentario_reseña())
                    .addParameter("valoracion", resenia.getValoracion())
                    .addParameter("id_usuarioR", resenia.getId_usuarioR())
                    .addParameter("id_librore", resenia.getId_librore())
                    .executeUpdate();
            System.out.println("Elemento agregado correctamente");
            return resenia;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Resenia> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Reseña ORDER BY id_reseña ASC")
                    .executeAndFetch(Resenia.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Resenia getResenia(int id_reseña) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Reseña WHERE id_reseña = :id_reseña")
                    .addParameter("id_reseña", id_reseña)
                    .executeAndFetchFirst(Resenia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Resenia actualizar(Resenia resenia) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Reseña SET comentario_reseña = :comentario_reseña, valoracion = :valoracion, " +
                    "id_usuarioR = :id_usuarioR, id_librore = :id_librore WHERE id_reseña = :id_reseña";
            conn.createQuery(sql)
                    .addParameter("comentario_reseña", resenia.getComentario_reseña())
                    .addParameter("valoracion", resenia.getValoracion())
                    .addParameter("id_usuarioR", resenia.getId_usuarioR())
                    .addParameter("id_librore", resenia.getId_librore())
                    .addParameter("id_reseña", resenia.getId_reseña())
                    .executeUpdate();
            return resenia;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_reseña) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Reseña WHERE id_reseña = :id_reseña";
            conn.createQuery(sql)
                    .addParameter("id_reseña", id_reseña)
                    .executeUpdate();
            System.out.println("Elemento eliminado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
