package cr.ac.ucenfotec.rojas.jandier.dl;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Cliente;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Cuenta;

import java.util.ArrayList;

public class Data {
    private ArrayList<Cliente> clientes;
    private ArrayList<Cuenta> cuentas;
    private ArrayList<Cuenta> cuentasCliente;


    public Data() {
        clientes = new ArrayList<>();
        cuentas = new ArrayList<>();
        cuentasCliente = new ArrayList<>();
    }


    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public ArrayList<Cuenta> getCuentasCliente() {
        return cuentasCliente;
    }

    public void setCuentasCliente(ArrayList<Cuenta> cuentasCliente) {
        this.cuentasCliente = cuentasCliente;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void agregarCuentasCliente(Cuenta cuenta) {
        cuentasCliente.add(cuenta);
    }
}
