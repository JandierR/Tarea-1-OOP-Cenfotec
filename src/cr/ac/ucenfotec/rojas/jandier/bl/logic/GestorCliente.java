package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Cliente;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Cuenta;

import java.util.ArrayList;

public class GestorCliente {
    private ArrayList<Cliente> clientes;
    private ArrayList<Cuenta> cuentas;

    public GestorCliente() {
        clientes = new ArrayList<>();
        cuentas = new ArrayList<>();
    }

    public String registrarCliente(String cedula, String nombre) {
        Cliente cliente = buscarClientePorCedula(cedula);

        if (cliente == null) {
            clientes.add(new Cliente(cedula, nombre));
            return "Cliente registrado exitosamente!";
        }
        return "Cliente ya existe";
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente buscarClientePorCedula(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean existeCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cuenta> listarCuentasPorCliente(String cedula) {
        Cliente cliente = buscarClientePorCedula(cedula);

        if (cliente != null) {
            return cliente.getCuentasDeCliente();
        }
        return null;
    }

    public ArrayList<Cuenta> listarSaldoCuentas(String cedula) {
        Cliente cliente = buscarClientePorCedula(cedula);
        if (cliente != null) {
            return cliente.getCuentasDeCliente();
        }
        return null;
    }

    public void agregarCuentaCliente(Cuenta cuenta, String cedula) {
        Cliente cliente = buscarClientePorCedula(cedula);
        if (cliente != null) {
            cliente.agregarCuenta(cuenta);
        }
    }


}
