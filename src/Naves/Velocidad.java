package Naves;

public enum Velocidad {
    BAJA(0.6),
    MEDIA(0.4),
    ALTA(0.2);

    private double porcentajePeligro = 0;

    Velocidad(double porcentajePeligro){
        this.porcentajePeligro = porcentajePeligro;
    }

    public double getPorcentajePeligro() {
        return porcentajePeligro;
    }
}
