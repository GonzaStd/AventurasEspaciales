package Peligros;

import Naves.Nave;

public class TormentaCosmica extends Peligro {

    public TormentaCosmica() {
        super(5, 20);
    }

    @Override
    public int getDanio(Nave nave) {
        return generarDanioBase();
    }
}