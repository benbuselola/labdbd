package dbd.LAB.crud.models;

public class UbicacionGeografica {
    private int id_ubicacion;
    private String pais;
    private int id_continente_u;

    public UbicacionGeografica(int id_ubicacion, String pais, int id_continente_u) {
        this.id_ubicacion = id_ubicacion;
        this.pais = pais;
        this.id_continente_u = id_continente_u;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getId_continente_u() {
        return id_continente_u;
    }

    public void setId_continente_u(int id_continente_u) {
        this.id_continente_u = id_continente_u;
    }
}
