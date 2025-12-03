package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta {

    private int operacionesExentas = 15;
    private double cuotaOperaciones;


    public CuentaCorriente(String nombreCliente, String cedulaCliente, double monto, String numCuenta, String tipo) {
        super(nombreCliente, cedulaCliente, monto, numCuenta, tipo);
    }

    public CuentaCorriente() {
    }

    @Override
    public double cobrarComisiones() {
        if ((getSaldo() > 0) && (LocalDate.now().getDayOfMonth() == 1) && (getOperaciones().size() > operacionesExentas)) {
            cuotaOperaciones = getSaldo() * getOperaciones().size();
            setSaldo(getSaldo() - cuotaOperaciones);
        }
        return -1;
    }
}
