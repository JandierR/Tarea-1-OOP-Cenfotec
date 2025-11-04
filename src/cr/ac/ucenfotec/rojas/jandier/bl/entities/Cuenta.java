package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.time.LocalDate;

public class Cuenta {
    private int cantCuentas;
    private String numCuenta;
    private double saldo;
    private LocalDate fechaCreacion;
    private String duenio;

    public Cuenta(String nombreCliente, double monto) {
        this.saldo = monto;
        this.duenio = nombreCliente;
        fechaCreacion = LocalDate.now();
    }

    public int getCantCuentas() {
        return cantCuentas;
    }

    public void setCantCuentas(int cantCuentas) {
        this.cantCuentas = cantCuentas;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return "cr.ac.ucenfotec.rojas.jandier.bl.entities.Cuenta{" +
                "cantCuentas=" + cantCuentas +
                ", numCuenta='" + numCuenta + '\'' +
                ", saldo=" + saldo +
                ", fechaCreacion=" + fechaCreacion +
                ", duenio='" + duenio + '\'' +
                '}';
    }
}
