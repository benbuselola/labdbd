package dbd.LAB.crud.models;

public class UsuarioRol {
    private int id_usuario_rol;
    private int id_usuario_ur;
    private int id_rol_ur;

    public UsuarioRol(int id_usuario_rol, int id_usuario_ur, int id_rol_ur) {
        this.id_usuario_rol = id_usuario_rol;
        this.id_usuario_ur = id_usuario_ur;
        this.id_rol_ur = id_rol_ur;
    }

    // Getters y setters (métodos de acceso)

    public int getId_usuario_rol() {
        return id_usuario_rol;
    }

    public void setId_usuario_rol(int id_usuario_rol) {
        this.id_usuario_rol = id_usuario_rol;
    }

    public int getId_usuario_ur() {
        return id_usuario_ur;
    }

    public void setId_usuario_ur(int id_usuario_ur) {
        this.id_usuario_ur = id_usuario_ur;
    }

    public int getId_rol_ur() {
        return id_rol_ur;
    }

    public void setId_rol_ur(int id_rol_ur) {
        this.id_rol_ur = id_rol_ur;
    }
}
