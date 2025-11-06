package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.time.LocalDate;

public class Cuenta {
    private int cantCuentas;
    private String numCuenta;
    private double saldo;
    private LocalDate fechaCreacion;
    private String cedulaCliente;
    private String nombreCliente;

    public Cuenta(String nombreCliente,String cedulaCliente, double monto, String numCuenta) {
        this.nombreCliente = nombreCliente;
        this.saldo = monto;
        this.cedulaCliente = cedulaCliente;
        this.numCuenta = numCuenta;
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

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "cantCuentas=" + cantCuentas +
                ", numCuenta='" + numCuenta + '\'' +
                ", saldo=" + saldo +
                ", fechaCreacion=" + fechaCreacion +
                ", cedulaCliente='" + cedulaCliente + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }

    public String depositar(double monto) {

        if (monto > 0) {
            saldo += monto;
            return "Deposito realizado con exito";
        }
        return "Monto invalido";
    }

    public String retirar(double monto) {
        if ((monto > 0) && (monto <= saldo)) {
            saldo -= monto;
            return "Retiro exitoso";
        }
        return "Monto invalido";
    }
}
