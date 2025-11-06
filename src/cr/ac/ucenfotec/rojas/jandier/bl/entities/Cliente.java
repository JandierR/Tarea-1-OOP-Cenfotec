package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.ArrayList;

public class Cliente {
    private String cedula;
    private String nombre;
    private ArrayList<Cuenta> cuentasDeCliente;

    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        cuentasDeCliente = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
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
    public void agregarCuenta(Cuenta cuenta) {
        cuentasDeCliente.add(cuenta);
    }
}
