package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Cuenta;

import java.util.ArrayList;

public class GestorCuenta {

    private ArrayList<Cuenta> cuentas;
    private GestorCliente gestorCliente;

    public GestorCuenta(GestorCliente gestorCliente) {
        this.cuentas = new ArrayList<>();
        this.gestorCliente = gestorCliente;
    }

    public String depositarEnCuenta(double monto, String numCuenta) {
        Cuenta cuenta = buscarPorNumCuenta(numCuenta);
        if (cuenta != null) {
//            double nuevoSaldo = cuenta.getSaldo() + monto;
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

    public String registrarCuenta(String nombreCliente, String cedula, double montoInicial, String numCuenta) {
        boolean existeCliente = gestorCliente.existeCliente(cedula);
        boolean existeCuenta = existeCuenta(numCuenta);

        if (existeCuenta) {
            return "Error --> Ya existe una cuenta con ese numero de cuenta";
        }
        if (!existeCliente) {
            return "Error --> No existe el cliente ingresado";
        }

        Cuenta nuevaCuenta = new Cuenta(nombreCliente, cedula, montoInicial, numCuenta);
        cuentas.add(nuevaCuenta);
        gestorCliente.agregarCuentaCliente(nuevaCuenta, cedula);
        return "Cuenta registrada exitosamente!";
    }

    public Cuenta buscarPorNumCuenta(String numCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumCuenta().equalsIgnoreCase(numCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

//    public Cliente buscarPorCedula(String cedula) {
//        for (Cliente cliente : ) {
//            if (cuenta.getCedulaCliente().equalsIgnoreCase(cedula)) {
//                return c;
//            }
//        }
//        return null;
//    }

    public boolean existeCuenta(String numCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumCuenta().equalsIgnoreCase(numCuenta)) {
                return true;
            }
        }
        return false;
    }

    public String obtenerOperacionesCuenta(String numCuenta) {
        Cuenta cuenta = buscarPorNumCuenta(numCuenta);

        if (cuenta == null) {
            return "Error ---> Cuenta no encontrada";
        }

        return cuenta.listarOperaciones();

    }

}
