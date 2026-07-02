package Planetas;

import Principal.Utilidades;

import java.util.Arrays;

public abstract class Planeta {

    protected Recurso[] recursos;
    protected double[] probabilidades;

    public Planeta(Recurso[] recursos, double[] probabilidades) {
        this.recursos = recursos;
        this.probabilidades = probabilidades;
    }

    public Recurso minado() {
        return Utilidades.generarElementoProbabilidad(probabilidades, recursos);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +  "{" +
                "  recursos=" + Arrays.toString(this.recursos) +
                ", probabilidades=" + Arrays.toString(this.probabilidades) +
                '}';
    }
}