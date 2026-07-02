package Peligros;

import Naves.Nave;
import Principal.Utilidades;

public abstract class Peligro {

    protected int fuerzaAtaqueMin;
    protected int fuerzaAtaqueMax;

    public Peligro(int fuerzaAtaqueMin, int fuerzaAtaqueMax) {
        this.fuerzaAtaqueMin = fuerzaAtaqueMin;
        this.fuerzaAtaqueMax = fuerzaAtaqueMax;
    }

    protected int generarDanioBase() {
        return Utilidades.generarRandom(fuerzaAtaqueMin, fuerzaAtaqueMax);
    }

    public abstract int getDanio(Nave nave);


    @Override
    public String toString() {
        return "Peligro{" +
                "  fuerzaAtaqueMin=" + this.fuerzaAtaqueMin +
                ", fuerzaAtaqueMax=" + this.fuerzaAtaqueMax +
                '}';
    }
}