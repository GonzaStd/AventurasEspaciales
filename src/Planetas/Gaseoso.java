package Planetas;

public class Gaseoso extends Planeta {

    public Gaseoso() {
        super(
                new Recurso[]{
                        Recurso.GAS,
                        Recurso.PLASMA,
                        Recurso.CRISTAL
                },
                new double[]{
                        0.60,
                        0.25,
                        0.15
                }
        );
    }
}