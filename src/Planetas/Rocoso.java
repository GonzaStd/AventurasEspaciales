package Planetas;

public class Rocoso extends Planeta {

    public Rocoso() {
        super(
                new Recurso[]{
                        Recurso.MINERAL_COMUN,
                        Recurso.CRISTAL,
                        Recurso.NUCLEO_ENERGETICO
                },
                new double[]{
                        0.60,
                        0.25,
                        0.15
                }
        );
    }
}