package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.time.LocalDate;

public class CuentaAhorro extends Cuenta {

    private double cuotaMantenimiento;

    public CuentaAhorro(String nombreCliente, String cedulaCliente, double monto, String numCuenta, String tipo) {
        super(nombreCliente, cedulaCliente, monto, numCuenta, tipo);
    }

    public CuentaAhorro() {
    }

    @Override
    public double cobrarComisiones() {

        if ((getSaldo() > 0) && (LocalDate.now().getDayOfMonth() == 1)) {
            cuotaMantenimiento = getSaldo() * 3.5;
            setSaldo(getSaldo() - cuotaMantenimiento);
        }
        return -1;
    }


}
