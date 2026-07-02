package Peligros;

import Naves.Nave;
import Naves.Velocidad;

public class Renegado extends Peligro {

    public Renegado() {
        super(3, 15);
    }

    @Override
    public int getDanio(Nave nave) {
        int danio = generarDanioBase();

        if (nave.getVelocidad() == Velocidad.BAJA) {
            danio *= 2;
        }

        return danio;
    }
}