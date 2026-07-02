package Misiones;

import Planetas.Recurso;

public class NucleoPrincipal extends Mision {

    @Override
    public Recurso[] getRecursosRequeridos() {
        return new Recurso[]{
                Recurso.NUCLEO_ENERGETICO,
                Recurso.OBSIDIANA
        };
    }

    @Override
    public int[] getCantidadesRequeridas() {
        return new int[]{
                1,
                2
        };
    }

    @Override
    public int getRecompensa() {
        return 250;
    }
}