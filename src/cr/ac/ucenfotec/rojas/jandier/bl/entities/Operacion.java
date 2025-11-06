package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.time.LocalDate;

public class Operacion {
    private int numero;
    private String tipo;
    private LocalDate fechaOperacion;
    private double monto;


    public Operacion(int numero, double monto, LocalDate fechaOperacion, String tipo) {
        this.numero = numero;
        this.monto = monto;
        this.fechaOperacion = fechaOperacion;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", fechaOperacion=" + fechaOperacion +
                ", monto=" + monto +
                '}';
    }
}
