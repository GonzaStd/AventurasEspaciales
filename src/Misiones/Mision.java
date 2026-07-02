package Misiones;

import Naves.Bodega;
import Planetas.Recurso;
import Principal.Jugador;

import java.util.Arrays;

public abstract class Mision {

    public abstract Recurso[] getRecursosRequeridos();

    public abstract int[] getCantidadesRequeridas();

    public abstract int getRecompensa();

    public boolean completar(Jugador jugador) {

        if (jugador.yaCompletada(this)) {
            System.out.println("La misión ya fue completada previamente.");
            return false;
        }

        Bodega bodega = jugador.getNave().getBodega();

        Recurso[] recursos = getRecursosRequeridos();
        int[] cantidades = getCantidadesRequeridas();

        for (int i = 0; i < recursos.length; i++) {

            if (!bodega.tieneRecursos(recursos[i], cantidades[i])) {

                System.out.println("No tenés los recursos necesarios.");

                return false;
            }
        }

        for (int i = 0; i < recursos.length; i++) {

            bodega.retirarRecursos(
                    recursos[i],
                    cantidades[i]
            );
        }

        jugador.adquirirCreditos(getRecompensa());

        jugador.misionCompletada(this);

        System.out.println("¡Misión completada!");

        return true;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "  recursosRequeridos=" + Arrays.toString(getRecursosRequeridos()) +
                ", cantidadesRequeridas=" + Arrays.toString(getCantidadesRequeridas()) +
                ", recompensa=" + getRecompensa() +
                '}';
    }
}