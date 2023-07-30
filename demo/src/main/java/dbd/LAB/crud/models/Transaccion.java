package dbd.LAB.crud.models;

import java.sql.Date;

public class Transaccion {
    private int id_transaccion;
    private Date fecha_boleta;
    private int id_pago;
    private int id_carro;

    public Transaccion(int id_transaccion, Date fecha_boleta, int id_pago, int id_carro) {
        this.id_transaccion = id_transaccion;
        this.fecha_boleta = fecha_boleta;
        this.id_pago = id_pago;
        this.id_carro = id_carro;
    }

    // Getters y setters (métodos de acceso)

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Date getFecha_boleta() {
        return fecha_boleta;
    }

    public void setFecha_boleta(Date fecha_boleta) {
        this.fecha_boleta = fecha_boleta;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }
}
