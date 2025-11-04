package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.time.LocalDate;

public class Operacion {
    private int numero;
    private String tipo;
    private LocalDate fechaOperacion;


    public Operacion(int numero, String tipo, LocalDate fechaOperacion) {
        this.numero = numero;
        this.tipo = tipo;
        this.fechaOperacion = fechaOperacion;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", fechaOperacion=" + fechaOperacion +
                '}';
    }
}
