package Naves;
import Planetas.Recurso;

import java.util.ArrayList;

public class Bodega {

    private final ArrayList<Recurso> recursos;
    private final int capacidadMaxima;

    public Bodega(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.recursos = new ArrayList<>();
    }

    public boolean guardarRecurso(Recurso recurso) {
        if (puedeGuardar(recurso)) {
            recursos.add(recurso);
            return true;
        }
        return false;
    }

    public boolean puedeGuardar(Recurso recurso) {
        return getCargaActual() + recurso.getPESO() <= capacidadMaxima;
    }

    public int getCargaActual() {
        int carga = 0;

        for (Recurso recurso : recursos) {
            carga += recurso.getPESO();
        }

        return carga;
    }

    public Recurso[] getRecursos() {
        Recurso[] copia = new Recurso[recursos.size()];

        for (int i = 0; i < recursos.size(); i++) {
            copia[i] = recursos.get(i);
        }

        return copia;
    }

    public boolean retirarRecursos(Recurso recursoBuscado, int cantidad) {

        if (!tieneRecursos(recursoBuscado, cantidad)) {
            return false;
        }

        int retirados = 0;

        for (int i = recursos.size() - 1; i >= 0 && retirados < cantidad; i--) {
            if (recursos.get(i) == recursoBuscado) {
                recursos.remove(i);
                retirados++;
            }
        }

        return true;
    }

    public boolean estaVacia() {
        return recursos.isEmpty();
    }

    public boolean tieneRecursos(Recurso recursoBuscado, int cantidadBuscada) {
        int cantidadEncontrada = 0;

        for (Recurso recurso : recursos) {
            if (recurso == recursoBuscado) {
                cantidadEncontrada++;

                if (cantidadEncontrada >= cantidadBuscada) {
                    return true;
                }
            }
        }

        return false;
    }

    public void mostrarRecursos() {
        if (estaVacia()) {
            System.out.println("La bodega está vacía.");
            return;
        }

        for (Recurso recurso : recursos) {
            System.out.println(recurso);
        }

        System.out.println("Carga: " + getCargaActual() + "/" + capacidadMaxima);
    }

    public int venderTodo() {
        int total = 0;
        for (Recurso recurso : recursos) {
            total += recurso.getPRECIO();
        }
        recursos.clear();
        return total;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "  recursos=" + this.recursos +
                ", capacidadMaxima=" + this.capacidadMaxima +
                '}';
    }
}
