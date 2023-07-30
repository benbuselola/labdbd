package dbd.LAB.crud.models;

public class LibroCarrito {
    private int id_libro_carrito;
    private int id_libro_lc;
    private int id_carrito_lc;

    public LibroCarrito(int id_libro_carrito, int id_libro_lc, int id_carrito_lc) {
        this.id_libro_carrito = id_libro_carrito;
        this.id_libro_lc = id_libro_lc;
        this.id_carrito_lc = id_carrito_lc;
    }

    // Getters y setters (métodos de acceso)

    public int getId_libro_carrito() {
        return id_libro_carrito;
    }

    public void setId_libro_carrito(int id_libro_carrito) {
        this.id_libro_carrito = id_libro_carrito;
    }

    public int getId_libro_lc() {
        return id_libro_lc;
    }

    public void setId_libro_lc(int id_libro_lc) {
        this.id_libro_lc = id_libro_lc;
    }

    public int getId_carrito_lc() {
        return id_carrito_lc;
    }

    public void setId_carrito_lc(int id_carrito_lc) {
        this.id_carrito_lc = id_carrito_lc;
    }
}
