package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.ArrayList;

public class Cliente {
    private String cedula;
    private String nombre;
    private ArrayList<Cuenta> cuentasDeCliente;
    private int cantidadCuentasAhorro;
    private int cantidadCuentasCorriente;

    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        cuentasDeCliente = new ArrayList<>();
        cantidadCuentasAhorro = 0;
        cantidadCuentasCorriente = 0;
    }


    @Override
    public String toString() {
        return "Cliente -> " + nombre + "\n" +
                "Cedula -> " + cedula + "\n" +
                "Cantidad de cuentas ahorro -> " + cantidadCuentasAhorro + "\n" +
                "Cantidad de cuentas corriente -> " + cantidadCuentasCorriente + "\n";
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cuenta> getCuentasDeCliente() {
        return cuentasDeCliente;
    }

    public void setCuentasDeCliente(ArrayList<Cuenta> cuentasDeCliente) {
        this.cuentasDeCliente = cuentasDeCliente;
    }

    public int getCantidadCuentas() {
        return cantidadCuentasAhorro;
    }

    public void setCantidadCuentas(int cantidadCuentas) {
        this.cantidadCuentasAhorro = cantidadCuentas;
    }

    public int getCantidadCuentasAhorro() {
        return cantidadCuentasAhorro;
    }

    public void setCantidadCuentasAhorro(int cantidadCuentasAhorro) {
        this.cantidadCuentasAhorro = cantidadCuentasAhorro;
    }

    public int getCantidadCuentasCorriente() {
        return cantidadCuentasCorriente;
    }

    public void setCantidadCuentasCorriente(int cantidadCuentasCorriente) {
        this.cantidadCuentasCorriente = cantidadCuentasCorriente;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentasDeCliente.add(cuenta);
    }
}
