package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Cuenta {
    private String numCuenta;
    private double saldo;
    private LocalDate fechaCreacion;
    private String cedulaCliente;
    private String nombreCliente;
    private ArrayList<Operacion> operaciones;
    private int contadorOperaciones;
    private String tipo;



    public Cuenta(String nombreCliente,String cedulaCliente, double monto, String numCuenta, String tipo) {
        this.nombreCliente = nombreCliente;
        this.saldo = monto;
        this.cedulaCliente = cedulaCliente;
        this.numCuenta = numCuenta;
        fechaCreacion = LocalDate.now();
        this.operaciones = new ArrayList<>();
        contadorOperaciones = 0;
        this.tipo = tipo;
    }

    public Cuenta() {
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

    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(ArrayList<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Numero cuenta -> " + numCuenta + '\n' +
                "Saldo -> " + saldo + "\n" +
                "Fecha de creación -> " + fechaCreacion + "\n" +
                "Cedula cliente -> " + cedulaCliente + '\n' +
                "Nombre cliente -> " + nombreCliente + '\n' +
                "Tipo de cuenta -> " + tipo + '\n';
    }

    public String depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            contadorOperaciones++;
            Operacion operacion = new Operacion(contadorOperaciones, monto, LocalDate.now(), "Deposito");
            operaciones.add(operacion);
            return "Deposito realizado con exito";
        }
        return "Monto invalido";
    }

    public String retirar(double monto) {
        if ((monto > 0) && (monto <= saldo)) {
            contadorOperaciones++;
            Operacion operacion = new Operacion(contadorOperaciones, monto, LocalDate.now(), "Retiro");
            operaciones.add(operacion);
            saldo -= monto;
            return "Retiro exitoso";
        }
        return "Monto invalido";
    }

    public String listarOperaciones() {
        if (operaciones.isEmpty()) {
            return "No hay operaciones por el momento";
        }

        String operacion = "";
        for (Operacion op : operaciones) {
            operacion += " " + op.toString() + "\n";
        }
        return operacion;
    }

    public abstract double cobrarComisiones();

}
