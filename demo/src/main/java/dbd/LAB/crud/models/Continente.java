package dbd.LAB.crud.models;

public class Continente {
    private int id_continente;
    private String continente;

    public Continente(int id_continente, String continente) {
        this.id_continente = id_continente;
        this.continente = continente;
    }

    // Getters y setters (métodos de acceso)

    public int getId_continente() {
        return id_continente;
    }

    public void setId_continente(int id_continente) {
        this.id_continente = id_continente;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }
}
