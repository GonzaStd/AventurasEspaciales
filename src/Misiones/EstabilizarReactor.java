package Misiones;

import Planetas.Recurso;

public class EstabilizarReactor extends Mision {

    @Override
    public Recurso[] getRecursosRequeridos() {
        return new Recurso[]{
                Recurso.GAS,
                Recurso.PLASMA
        };
    }

    @Override
    public int[] getCantidadesRequeridas() {
        return new int[]{
                2,
                1
        };
    }

    @Override
    public int getRecompensa() {
        return 170;
    }
}