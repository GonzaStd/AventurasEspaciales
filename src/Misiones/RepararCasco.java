package Misiones;

import Planetas.Recurso;

public class RepararCasco extends Mision {

    @Override
    public Recurso[] getRecursosRequeridos() {
        return new Recurso[]{
                Recurso.MINERAL_COMUN,
                Recurso.CRISTAL
        };
    }

    @Override
    public int[] getCantidadesRequeridas() {
        return new int[]{
                3,
                1
        };
    }

    @Override
    public int getRecompensa() {
        return 120;
    }
}