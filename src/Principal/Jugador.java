package Principal;

import Misiones.Mision;
import Naves.Nave;
import Planetas.Planeta;
import Planetas.Recurso;
import java.util.ArrayList;


public class Jugador {
    private String nombre = null;
    private int porcentajeEnergia = 100;
    private int creditosEspaciales = 0;
    private Nave naveElegida = null;
    private Planeta planetaActual = null;
    private ArrayList<Mision> misionesCompletadas = new ArrayList<Mision>();

    public Jugador(String nombre, Nave naveElegida){
        this.nombre = nombre;
        this.naveElegida = naveElegida;
        this.misionesCompletadas = new ArrayList<Mision>();
    }

    public void adquirirCreditos(int cantidad){
        this.creditosEspaciales += cantidad;
    }

    public void utilizarCreditos(int cantidad){
        this.creditosEspaciales -= cantidad;
    }

    public int getCreditos() {
        return creditosEspaciales;
    }

    public int getMisionesCompletadas() {
        return this.misionesCompletadas.size();
    }

    public void minar() {
        int porcentajeEnergiaRequerida = Utilidades.generarRandom(10, 25);

        if (porcentajeEnergiaRequerida > porcentajeEnergia) {
            System.out.println(
                    "Energía agotada para este trabajo (" +
                            porcentajeEnergia + "% disponible, " +
                            porcentajeEnergiaRequerida + "% necesaria)"
            );
            return;
        }

        Recurso recursoObtenido = planetaActual.minado();

        System.out.println("Encontraste " + recursoObtenido);

        boolean recursoGuardado = naveElegida.getBodega().guardarRecurso(recursoObtenido);

        porcentajeEnergia -= porcentajeEnergiaRequerida;

        if (!recursoGuardado) {
            System.out.println(
                    "Perdiste el recurso " +
                            recursoObtenido.name() +
                            " porque no tenés espacio."
            );
        }

        System.out.println(
                "Usaste " + porcentajeEnergiaRequerida +
                        "% de energía, te queda un " +
                        porcentajeEnergia + "%."
        );
    }

    public void viajar(Planeta planeta) {
        this.planetaActual = planeta;
    }

    public Nave getNave() {
        return naveElegida;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "  nombre='" + this.nombre + '\'' +
                ", porcentajeEnergia=" + this.porcentajeEnergia +
                ", creditosEspaciales=" + this.creditosEspaciales +
                ", naveElegida=" + this.naveElegida.getClass().getSimpleName() +
                ", planetaActual=" + this.planetaActual +
                ", misionesCompletadas=" + this.misionesCompletadas +
                '}';
    }

    public void descansar() {
        this.porcentajeEnergia = 100;
    }


    public void misionCompletada(Mision mision) {
        this.misionesCompletadas.add(mision);
        System.out.println("¡Misión completada!");
    }

    public int getEnergia() {
        return this.porcentajeEnergia;
    }

    public boolean yaCompletada(Mision mision) {
        for (Mision m : misionesCompletadas) {
            if (m.getClass().equals(mision.getClass())) {
                return true;
            }
        }
        return false;
    }

}
