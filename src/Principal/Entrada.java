package Principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    private Scanner s;

    public Entrada(){
        this.s = new Scanner(System.in);
    }

    public <T> T seleccionarElemento(T[] elementos) {
        System.out.println();

        for (int i = 0; i < elementos.length; i++) {
            int numero = i + 1;
            T elemento = elementos[i];

            String texto = elemento.toString();
            texto = texto.replace("\n", "\n    ");

            System.out.println("[" + numero + "]");
            System.out.println("    " + texto);
            System.out.println();
        }

        int opcion = this.ingresarEntero(1, elementos.length);

        return elementos[opcion - 1];
    }

    public int ingresarEntero(int min, int max){
        int opc = 0;
        boolean error = false;

        do {
            error = false;
            System.out.println("Ingrese una opción entre "+min+" y "+max+":");
            try {
                opc = s.nextInt();
                if(opc<min || opc>max){
                    System.out.println("Opción inválida, el número debe estar entre "+min+" y "+max+". Intente nuevamente.");
                    error = true;
                }
            } catch(InputMismatchException e){
                System.out.println("El dato ingresado debe ser un número, intente nuevamente.");
                error = true;
            } finally {
                s.nextLine();
            }
        } while(error);

        return opc;

    }

    public String ingresarTexto(){
        return s.nextLine();
    }

    public void cerrarScanner(){
        s.close();
    }

}