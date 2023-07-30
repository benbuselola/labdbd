package dbd.LAB.crud.models;

public class Restriccion {
    private int id_restriccion;
    private int edad;

    public Restriccion(int id_restriccion, int edad) {
        this.id_restriccion = id_restriccion;
        this.edad = edad;
    }

    // Getters y setters (métodos de acceso)

    public int getId_restriccion() {
        return id_restriccion;
    }

    public void setId_restriccion(int id_restriccion) {
        this.id_restriccion = id_restriccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
