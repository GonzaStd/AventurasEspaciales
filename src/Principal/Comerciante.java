package Principal;

import static Principal.Constantes.MISIONES;
import static Principal.Constantes.PLANETAS;
import Misiones.*;
import Naves.Bodega;
import Planetas.Planeta;
import Planetas.Recurso;
import java.util.Arrays;

public class Comerciante {
    private Jugador jugador = null;
    private Mision[] misiones;
    private final int PRECIO_REPARACION = 25;


    public Comerciante(Jugador jugadorAAtender){
        this.jugador = jugadorAAtender;
    }

    public void comprarReparaciones(Entrada e){
        final int MAXIMAS_REPARACIONES = this.jugador.getNave().getReparacionesDisponibles();

        int cantidadReparaciones = e.ingresarEntero(1, MAXIMAS_REPARACIONES);

        jugador.utilizarCreditos(cantidadReparaciones*PRECIO_REPARACION);

        jugador.getNave().reparar(cantidadReparaciones);
    }

    public void venderRecurso(Entrada e) {

        Bodega bodega = jugador.getNave().getBodega();

        if (bodega.estaVacia()) {
            System.out.println("La bodega está vacía.");
            return;
        }

        System.out.println("[1] Vender un recurso específico\n[2] Vender todos los recursos");
        int opc = e.ingresarEntero(1,2);

        if (opc == 1) {
            Recurso recurso = e.seleccionarElemento(bodega.getRecursos());

            if (bodega.retirarRecursos(recurso, 1)) {

                jugador.adquirirCreditos(recurso.getPRECIO());

                System.out.println("Vendido correctamente.");
            }
        } else {
            int total = bodega.venderTodo();
            jugador.adquirirCreditos(total);
            System.out.println("Vendiste todos los recursos por " + total + " créditos.");
        }
    }

    public void repararNave(Entrada e) {

        int reparacionesDisponibles = jugador.getNave().getReparacionesDisponibles();

        if (reparacionesDisponibles == 0) {
            System.out.println("La nave no necesita reparaciones.");
            return;
        }

        int reparacionesPagables = jugador.getCreditos() / PRECIO_REPARACION;

        if (reparacionesPagables == 0) {
            System.out.println("No tenés créditos suficientes para reparar la nave.");
            return;
        }

        int maximo = Math.min(reparacionesDisponibles, reparacionesPagables);

        System.out.println("Podés comprar hasta " + maximo + " reparación(es).");
        System.out.println("Cada reparación cuesta " + PRECIO_REPARACION + " créditos.");

        int cantidad = e.ingresarEntero(1, maximo);

        jugador.utilizarCreditos(cantidad * PRECIO_REPARACION);
        jugador.getNave().reparar(cantidad);

        System.out.println("La nave fue reparada correctamente.");
    }

    public void prepararViaje(Entrada e) {

        Planeta planeta = e.seleccionarElemento(Constantes.PLANETAS);

        jugador.viajar(planeta);

        jugador.getNave().aterrizar();

        if (jugador.getNave().getVida() <= 0) {
            return;
        }

        boolean volver = false;

        while (!volver) {

            System.out.println("\nEstás en " + planeta);

            String[] opciones = {
                    "Minar",
                    "Viajar a otro planeta",
                    "Volver a la base"
            };

            int opc = Arrays.asList(opciones)
                    .indexOf(e.seleccionarElemento(opciones));

            switch (opc) {
                case 0 -> jugador.minar();

                case 1 -> prepararViaje(e);

                case 2 -> volver = true;
            }
        }
    }

    public void verMisionesDisponibles() {
        int item;
        for (int i = 0; i< MISIONES.length; i++){
            item = i + 1;
            String estado = jugador.yaCompletada(MISIONES[i]) ? "Completada" : "Pendiente";
            System.out.println(item + ") " + MISIONES[i] + " - " + estado + "\n");
        }
    }

    public void completarMision(Entrada e) {

        Mision mision = e.seleccionarElemento(MISIONES);

        if (mision.completar(jugador)) {
            System.out.println("¡Misión completada!");
        } else {
            System.out.println("No fue posible completar la misión.");
        }
    }
}
