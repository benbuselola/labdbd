package dbd.LAB.crud.models;

public class CategoriaLibro {
    private int id_categoria_libro;
    private int id_libro_cl;
    private int id_categoria_cl;

    public CategoriaLibro(int id_categoria_libro, int id_libro_cl, int id_categoria_cl) {
        this.id_categoria_libro = id_categoria_libro;
        this.id_libro_cl = id_libro_cl;
        this.id_categoria_cl = id_categoria_cl;
    }

    // Getters y setters (métodos de acceso)

    public int getId_categoria_libro() {
        return id_categoria_libro;
    }

    public void setId_categoria_libro(int id_categoria_libro) {
        this.id_categoria_libro = id_categoria_libro;
    }

    public int getId_libro_cl() {
        return id_libro_cl;
    }

    public void setId_libro_cl(int id_libro_cl) {
        this.id_libro_cl = id_libro_cl;
    }

    public int getId_categoria_cl() {
        return id_categoria_cl;
    }

    public void setId_categoria_cl(int id_categoria_cl) {
        this.id_categoria_cl = id_categoria_cl;
    }
}
