package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Cliente;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Cuenta;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.CuentaAhorro;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.CuentaCorriente;
import cr.ac.ucenfotec.rojas.jandier.dl.Data;

public class GestorCuenta {

    private GestorCliente gestorCliente;
    private Data data;

    public GestorCuenta(Data data, GestorCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
        this.data = data;

    }

    public String depositarEnCuenta(double monto, String numCuenta) {
        Cuenta cuenta = buscarPorNumCuenta(numCuenta);
        if (cuenta != null) {
            cuenta.depositar(monto);
            return "Deposito de $" + monto + " realizado exitosamente a la cuenta '" + numCuenta + "'";
        }

        return "Deposito invalido";
    }

    //Hacer lo mismo de depositarEnCuenta pero con retirar
    public String retirarEnCuenta(double monto, String numCuenta) {
        Cuenta cuenta = buscarPorNumCuenta(numCuenta);
        if (cuenta != null) {
            cuenta.retirar(monto);
            return "Retiro de $" + monto + " realizado exitosamente";
        }
        return "Retiro invalido";
    }

    public String registrarCuenta(String nombreCliente, String cedula, double montoInicial, String numCuenta, String tipo) {
        boolean existeCliente = gestorCliente.existeCliente(cedula);
        boolean existeCuenta = existeCuenta(numCuenta);
        Cliente cliente = gestorCliente.buscarClientePorCedula(cedula);

        if (existeCuenta) {
            return "Error --> Ya existe una cuenta con ese numero de cuenta";
        }
        if (!existeCliente) {
            return "Error --> No existe el cliente ingresado";
        }

        if (tipo.equalsIgnoreCase("Cuenta ahorro")) {
            CuentaAhorro cuentaAhorro = new CuentaAhorro(nombreCliente, cedula, montoInicial, numCuenta, tipo);
            data.agregarCuenta(cuentaAhorro);
//            cuentaAhorro.setCantCuentas(cuentaAhorro.getCantCuentas() + 1);
            gestorCliente.agregarCuentaCliente(cuentaAhorro, cedula);
            cliente.setCantidadCuentasAhorro(cliente.getCantidadCuentasAhorro() + 1);


            return "Cuenta registrada exitosamente!";

        } else if (tipo.equalsIgnoreCase("Cuenta corriente")) {
            CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreCliente, cedula, montoInicial, numCuenta, tipo);
            data.agregarCuenta(cuentaCorriente);
//            cuentaCorriente.setCantCuentas(cuentaCorriente.getCantCuentas() + 1);
            cliente.setCantidadCuentasCorriente(cliente.getCantidadCuentasCorriente() + 1);
            gestorCliente.agregarCuentaCliente(cuentaCorriente, cedula);
            return "Cuenta registrada exitosamente!";
        }

        return "Error";
    }


    public Cuenta buscarPorNumCuenta(String numCuenta) {
        for (Cuenta cuenta : data.getCuentas()) {
            if (cuenta.getNumCuenta().equalsIgnoreCase(numCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean existeCuenta(String numCuenta) {
        return buscarPorNumCuenta(numCuenta) != null;
    }

    public String obtenerOperacionesCuenta(String numCuenta) {
        Cuenta cuenta = buscarPorNumCuenta(numCuenta);

        if (cuenta == null) {
            return "Error ---> Cuenta no encontrada";
        }

        return cuenta.listarOperaciones();

    }

}
