package dbd.LAB.crud.models;

public class LibroFavorito {
    private int id_libro_favorito;
    private int id_usuario_f;
    private int id_libro_f;

    public LibroFavorito(int id_libro_favorito, int id_usuario_f, int id_libro_f) {
        this.id_libro_favorito = id_libro_favorito;
        this.id_usuario_f = id_usuario_f;
        this.id_libro_f = id_libro_f;
    }

    // Getters y setters (métodos de acceso)

    public int getId_libro_favorito() {
        return id_libro_favorito;
    }

    public void setId_libro_favorito(int id_libro_favorito) {
        this.id_libro_favorito = id_libro_favorito;
    }

    public int getId_usuario_f() {
        return id_usuario_f;
    }

    public void setId_usuario_f(int id_usuario_f) {
        this.id_usuario_f = id_usuario_f;
    }

    public int getId_libro_f() {
        return id_libro_f;
    }

    public void setId_libro_f(int id_libro_f) {
        this.id_libro_f = id_libro_f;
    }
}
