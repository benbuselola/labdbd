package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CarritoImp implements CarritoRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Carrito crear(Carrito carrito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Carrito(id_carrito, monto_total, cantidad_producto, carrito_comprado) VALUES (:id_carrito, :monto_total, :cantidad_producto, :carrito_comprado)";
            conn.createQuery(sql, true)
                    .addParameter("id_carrito", carrito.getId_carrito())
                    .addParameter("monto_total", carrito.getMonto_total())
                    .addParameter("cantidad_producto", carrito.getCantidad_producto())
                    .addParameter("carrito_comprado", carrito.isCarrito_comprado())
                    .executeUpdate();
            return carrito;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Carrito> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Carrito ORDER BY id_carrito ASC")
                    .executeAndFetch(Carrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Carrito getCarrito(int id_carrito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Carrito WHERE id_carrito = :id_carrito")
                    .addParameter("id_carrito", id_carrito)
                    .executeAndFetchFirst(Carrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Carrito actualizar(Carrito carrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Carrito SET monto_total = :monto_total, cantidad_producto = :cantidad_producto, carrito_comprado = :carrito_comprado WHERE id_carrito = :id_carrito";
            conn.createQuery(sql)
                    .addParameter("monto_total", carrito.getMonto_total())
                    .addParameter("cantidad_producto", carrito.getCantidad_producto())
                    .addParameter("carrito_comprado", carrito.isCarrito_comprado())
                    .addParameter("id_carrito", carrito.getId_carrito())
                    .executeUpdate();
            return carrito;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void borrar(int id_carrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Carrito WHERE id_carrito = :id_carrito";
            conn.createQuery(sql)
                    .addParameter("id_carrito", id_carrito)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
