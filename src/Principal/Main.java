package Principal;

import Naves.Nave;

public class Main {
    public static void main(String[] args) {
        Entrada e = new Entrada();
        System.out.println("Inicio");
        Jugador jugador = generarJugador(e);
        Comerciante comerciante = new Comerciante(jugador);
        System.out.println("Entrando a base espacial...");
        boolean salir;
        do {
            salir = baseEspacial(e, jugador, comerciante);
        } while (!salir && jugador.getNave().getVida() > 0);
        finJuego(jugador);
        e.cerrarScanner();
    }

    static Jugador generarJugador(Entrada e){
        System.out.println("Ingresar nombre del jugador: ");
        String nombreJugador = e.ingresarTexto();
        Nave naveJugador = e.seleccionarElemento(Constantes.NAVES);
        Jugador jugador = new Jugador(nombreJugador, naveJugador);
        System.out.println("Datos del jugador:\n" + jugador);
        return jugador;
    }

    static boolean baseEspacial(Entrada e, Jugador jugador, Comerciante comerciante){
        boolean salir = false;
        System.out.println("=== Estado del jugador ===");
        System.out.println("Nombre: " + jugador.getNombre());
        System.out.println("Energía: " + jugador.getEnergia() + "%");
        System.out.println("Créditos: " + jugador.getCreditos());
        System.out.println("Nave: " + jugador.getNave().getClass().getSimpleName());
        System.out.println("Velocidad: " + jugador.getNave().getVelocidad());
        System.out.println("Vida nave: " + jugador.getNave().getVida() + "%");
        System.out.println("Capacidad bodega: " + jugador.getNave().getBodega().getCapacidadMaxima() + " toneladas");
        System.out.println("Carga actual: " + jugador.getNave().getBodega().getCargaActual() + " toneladas");
        System.out.println("-------------------------");

        System.out.println("Seleccione una opción:");
        System.out.println("""
                1. Viajar a un planeta
                2. Ver bodega de carga
                3. Vender recursos
                4. Ver misiones disponibles
                5. Entregar recursos para una misión
                6. Reparar nave
                7. Descansar
                8. Salir del juego
                Opción:""");
        int opc = e.ingresarEntero(1, 8);
        switch (opc) {
            case 1:
                comerciante.prepararViaje(e);
                break;
            case 2:
                System.out.println(jugador.getNave().getBodega()); // Esta vez getBodega entrega una copia nomás así que espero que sea la solución para el encapsulamiento, sinó no sé.
                break;
            case 3:
                comerciante.venderRecurso(e);
                break;
            case 4:
                comerciante.verMisionesDisponibles();
                break;
            case 5:
                comerciante.completarMision(e);
                break;
            case 6:
                comerciante.repararNave(e);
                break;
            case 7:
                jugador.descansar();
                break;
            case 8:
                salir = true;
                break;
        }
        return salir;
    }

    public static void finJuego(Jugador jugador) {

        boolean gano =
                jugador.getNave().getVida() > 0 &&
                        jugador.getMisionesCompletadas() == 3;

        System.out.println("\n========== FIN DEL JUEGO ==========");

        System.out.println("Jugador: " + jugador.getNombre());
        System.out.println("Nave: " + jugador.getNave().getClass().getSimpleName());
        System.out.println("Vida restante: " + jugador.getNave().getVida() + "%");
        System.out.println("Créditos obtenidos: " + jugador.getCreditos());
        System.out.println("Misiones completadas: "
                + jugador.getMisionesCompletadas() + "/3");

        System.out.println("\nRecursos restantes en la bodega:");
        jugador.getNave().getBodega().mostrarRecursos();

        System.out.println("\nResultado final: "
                + (gano ? "¡Victoria!" : "Derrota"));

        System.out.println("===================================");
    }

}