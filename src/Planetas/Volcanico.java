package Planetas;

public class Volcanico extends Planeta {

    public Volcanico() {
        super(
                new Recurso[]{
                        Recurso.LAVA,
                        Recurso.OBSIDIANA,
                        Recurso.NUCLEO_ENERGETICO
                },
                new double[]{
                        0.50,
                        0.30,
                        0.20
                }
        );
    }
}