package dbd.LAB.crud.models;

public class MedioPago {
    private int id_medio_pago;
    private String medio_pago;

    public MedioPago(int id_medio_pago, String medio_pago) {
        this.id_medio_pago = id_medio_pago;
        this.medio_pago = medio_pago;
    }

    // Getters y setters (métodos de acceso)

    public int getId_medio_pago() {
        return id_medio_pago;
    }

    public void setId_medio_pago(int id_medio_pago) {
        this.id_medio_pago = id_medio_pago;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }
}
