package Peligros;

import Naves.Nave;
import Naves.Velocidad;

public class PirataEspacial extends Peligro {

    public PirataEspacial() {
        super(3, 15);
    }

    @Override
    public int getDanio(Nave nave) {
        int danio = generarDanioBase();

        if (nave.getVelocidad() == Velocidad.ALTA) {
            danio *= 2;
        }

        return danio;
    }
}