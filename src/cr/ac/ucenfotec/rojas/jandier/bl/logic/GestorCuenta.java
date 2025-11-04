package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Cuenta;

import java.util.ArrayList;

public class GestorCuenta {

    private ArrayList<Cuenta> cuentas;

    public GestorCuenta() {
        this.cuentas = new ArrayList<>();
    }

    public String depositar(double monto, String numCuenta) {
        Cuenta cuenta = buscarPorNumCuenta(numCuenta);
        if (cuenta != null) {
            double nuevoSaldo = cuenta.getSaldo() + monto;
            return "Deposito de $" + monto + " realizado exitosamente a la cuenta '" + numCuenta + "'";
        }

        return "Cuenta no encontrada!";
    }

    public String retirar(double monto) {
        return "Retiro de $" + monto + " realizado exitosamente";
    }

    public void registrarCuenta(String nombreCliente, double montoInicial) {
        cuentas.add(new Cuenta(nombreCliente, montoInicial));
    }

    public Cuenta buscarPorNumCuenta(String numCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumCuenta().equalsIgnoreCase(numCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}
