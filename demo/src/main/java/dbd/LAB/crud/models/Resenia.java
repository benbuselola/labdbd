package dbd.LAB.crud.models;

public class Resenia {
    private int id_reseña;
    private String comentario_reseña;
    private int valoracion;
    private int id_usuarioR;
    private int id_librore;

    public Resenia(int id_reseña, String comentario_reseña, int valoracion, int id_usuarioR, int id_librore) {
        this.id_reseña = id_reseña;
        this.comentario_reseña = comentario_reseña;
        this.valoracion = valoracion;
        this.id_usuarioR = id_usuarioR;
        this.id_librore = id_librore;
    }

    // Getters y setters (métodos de acceso)

    public int getId_reseña() {
        return id_reseña;
    }

    public void setId_reseña(int id_reseña) {
        this.id_reseña = id_reseña;
    }

    public String getComentario_reseña() {
        return comentario_reseña;
    }

    public void setComentario_reseña(String comentario_reseña) {
        this.comentario_reseña = comentario_reseña;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public int getId_usuarioR() {
        return id_usuarioR;
    }

    public void setId_usuarioR(int id_usuarioR) {
        this.id_usuarioR = id_usuarioR;
    }

    public int getId_librore() {
        return id_librore;
    }

    public void setId_librore(int id_librore) {
        this.id_librore = id_librore;
    }
}
