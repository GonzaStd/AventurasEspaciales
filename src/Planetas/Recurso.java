package Planetas;

public enum Recurso {
    MINERAL_COMUN(10, 10),
    CRISTAL(15, 35),
    NUCLEO_ENERGETICO(40, 80),
    GAS(20, 15),
    PLASMA(25, 45),
    LAVA(30, 20),
    OBSIDIANA(25, 50);

    private final int PESO;
    private final int PRECIO;

    Recurso(final int PESO, final int PRECIO) {
        this.PESO = PESO;
        this.PRECIO = PRECIO;
    }

    public int getPESO() {
        return PESO;
    }

    public int getPRECIO() {
        return PRECIO;
    }

    @Override
    public String toString() {
        return "TipoRecurso{" +
                "  PESO=" + this.PESO +
                ", PRECIO=" + this.PRECIO +
                '}';
    }
}
