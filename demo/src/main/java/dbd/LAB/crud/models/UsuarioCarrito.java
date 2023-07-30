package dbd.LAB.crud.models;

public class UsuarioCarrito {
    private int id_usuario_carrito;
    private int id_usuario_uc;
    private int id_carrito_uc;

    public UsuarioCarrito(int id_usuario_carrito, int id_usuario_uc, int id_carrito_uc) {
        this.id_usuario_carrito = id_usuario_carrito;
        this.id_usuario_uc = id_usuario_uc;
        this.id_carrito_uc = id_carrito_uc;
    }

    // Getters y setters (métodos de acceso)

    public int getId_usuario_carrito() {
        return id_usuario_carrito;
    }

    public void setId_usuario_carrito(int id_usuario_carrito) {
        this.id_usuario_carrito = id_usuario_carrito;
    }

    public int getId_usuario_uc() {
        return id_usuario_uc;
    }

    public void setId_usuario_uc(int id_usuario_uc) {
        this.id_usuario_uc = id_usuario_uc;
    }

    public int getId_carrito_uc() {
        return id_carrito_uc;
    }

    public void setId_carrito_uc(int id_carrito_uc) {
        this.id_carrito_uc = id_carrito_uc;
    }
}
