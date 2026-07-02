package Naves;

import Peligros.*;
import Planetas.*;
import Principal.Utilidades;

import static Principal.Constantes.PELIGROS;

public class Nave {

    private int vida = 100;
    private String nombre;
    private Velocidad velocidad;
    private Bodega bodega;

    public Nave(String nombre, Velocidad velocidad, int capacidadBodega) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.bodega = new Bodega(capacidadBodega);
    }

    public Velocidad getVelocidad() {
        return velocidad;
    }

    public int getVida() {
        return vida;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public int getReparacionesDisponibles() {
        final int VIDA_MAX = 100;
        int vidaFaltante = VIDA_MAX - vida;
        return (int) Math.ceil((double) vidaFaltante / 10);
    }

    public void reparar(int cantidad) {
        vida += cantidad * 10;

        if (vida > 100) {
            vida = 100;
        }
    }


    public void aterrizar() {
        boolean estaEnPeligro = Boolean.TRUE.equals(
                Utilidades.generarElementoProbabilidad(
                        new double[]{velocidad.getPorcentajePeligro()},
                        new Boolean[]{true}
                )
        );

        if (estaEnPeligro) {

            Peligro peligro = PELIGROS[Utilidades.generarRandom(0, PELIGROS.length-1)];

            int danioRecibido = peligro.getDanio(this);

            vida -= danioRecibido;

            System.out.println("¡Peligro! " + peligro +
                    " te hizo " + danioRecibido + "% de daño.");

            if (vida <= 0) {
                vida = 0;
                System.out.println("Tu nave fue destruida.");
            }

        } else {
            System.out.println("Aterrizaste sin sufrir ningún daño.");
        }
    }

    @Override
    public String toString() {
        return "Nave{" +
                "  vida=" + this.vida +
                ", nombre='" + this.nombre + '\'' +
                ", velocidad=" + this.velocidad +
                ", bodega=" + this.bodega +
                '}';
    }
}