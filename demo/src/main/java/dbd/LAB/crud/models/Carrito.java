package dbd.LAB.crud.models;

public class Carrito {
    private int id_carrito;
    private int monto_total;
    private int cantidad_producto;
    private boolean carrito_comprado;

    public Carrito(int id_carrito, int monto_total, int cantidad_producto, boolean carrito_comprado) {
        this.id_carrito = id_carrito;
        this.monto_total = monto_total;
        this.cantidad_producto = cantidad_producto;
        this.carrito_comprado = carrito_comprado;
    }

    // Getters y setters (métodos de acceso)

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public boolean isCarrito_comprado() {
        return carrito_comprado;
    }

    public void setCarrito_comprado(boolean carrito_comprado) {
        this.carrito_comprado = carrito_comprado;
    }
}
