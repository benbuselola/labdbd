package dbd.LAB.crud.models;

public class Libro {
    private int id_libro;
    private String autor;
    private String nombre_libro;
    private int precio;
    private int stock_libro;
    private int cantidad_ventas;
    private float valoracion_media;
    private int cantidad_favorito;
    private int id_ubicacion_libro;
    private int id_restriccion_libro;

    public Libro(int id_libro, String autor, String nombre_libro, int precio, int stock_libro, int cantidad_ventas, float valoracion_media, int cantidad_favorito, int id_ubicacion_libro, int id_restriccion_libro) {
        this.id_libro = id_libro;
        this.autor = autor;
        this.nombre_libro = nombre_libro;
        this.precio = precio;
        this.stock_libro = stock_libro;
        this.cantidad_ventas = cantidad_ventas;
        this.valoracion_media = valoracion_media;
        this.cantidad_favorito = cantidad_favorito;
        this.id_ubicacion_libro = id_ubicacion_libro;
        this.id_restriccion_libro = id_restriccion_libro;
    }

    // Getters y setters (métodos de acceso)

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock_libro() {
        return stock_libro;
    }

    public void setStock_libro(int stock_libro) {
        this.stock_libro = stock_libro;
    }

    public int getCantidad_ventas() {
        return cantidad_ventas;
    }

    public void setCantidad_ventas(int cantidad_ventas) {
        this.cantidad_ventas = cantidad_ventas;
    }

    public float getValoracion_media() {
        return valoracion_media;
    }

    public void setValoracion_media(float valoracion_media) {
        this.valoracion_media = valoracion_media;
    }

    public int getCantidad_favorito() {
        return cantidad_favorito;
    }

    public void setCantidad_favorito(int cantidad_favorito) {
        this.cantidad_favorito = cantidad_favorito;
    }

    public int getId_ubicacion_libro() {
        return id_ubicacion_libro;
    }

    public void setId_ubicacion_libro(int id_ubicacion_libro) {
        this.id_ubicacion_libro = id_ubicacion_libro;
    }

    public int getId_restriccion_libro() {
        return id_restriccion_libro;
    }

    public void setId_restriccion_libro(int id_restriccion_libro) {
        this.id_restriccion_libro = id_restriccion_libro;
    }
}
