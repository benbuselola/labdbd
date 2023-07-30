package dbd.LAB.crud.models;

import java.util.Date;

public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String contraseña;
    private Date fecha_nacimiento;
    private String mail;
    private int id_ubicacion_usuario;

    public Usuario(int id_usuario, String nombre_usuario, String contraseña, Date fecha_nacimiento, String mail, int id_ubicacion_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.fecha_nacimiento = fecha_nacimiento;
        this.mail = mail;
        this.id_ubicacion_usuario = id_ubicacion_usuario;
    }

    // Getters y setters (métodos de acceso)

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId_ubicacion_usuario() {
        return id_ubicacion_usuario;
    }

    public void setId_ubicacion_usuario(int id_ubicacion_usuario) {
        this.id_ubicacion_usuario = id_ubicacion_usuario;
    }
}
