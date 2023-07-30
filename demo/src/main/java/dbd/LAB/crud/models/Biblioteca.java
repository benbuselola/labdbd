package dbd.LAB.crud.models;

public class Biblioteca {
    private int id_biblioteca;
    private int id_usuario_B;
    private int id_libro_B;
    private boolean visualizacion;

    public Biblioteca(int id_biblioteca, int id_usuario_B, int id_libro_B, boolean visualizacion) {
        this.id_biblioteca = id_biblioteca;
        this.id_usuario_B = id_usuario_B;
        this.id_libro_B = id_libro_B;
        this.visualizacion = visualizacion;
    }

    // Getters y setters (métodos de acceso)

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public int getId_usuario_B() {
        return id_usuario_B;
    }

    public void setId_usuario_B(int id_usuario_B) {
        this.id_usuario_B = id_usuario_B;
    }

    public int getId_libro_B() {
        return id_libro_B;
    }

    public void setId_libro_B(int id_libro_B) {
        this.id_libro_B = id_libro_B;
    }

    public boolean isVisualizacion() {
        return visualizacion;
    }

    public void setVisualizacion(boolean visualizacion) {
        this.visualizacion = visualizacion;
    }
}
