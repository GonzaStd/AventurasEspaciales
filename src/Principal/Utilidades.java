package Principal;

public class Utilidades {
    public static <T> T generarElementoProbabilidad(double[] probabilidades, T[] elementos) {
        if (probabilidades.length != elementos.length){
            System.out.println("Error: El programador hizo algo mal. Las probabilidades y los elementos deberían tener el mismo tamaño.");
            System.exit(1);
        }
        double probAcum = 0.0;
        for (double p : probabilidades){
            probAcum += p;
        }
        if (probAcum != 1) {
            System.out.println("Error: El programador no pasó un array de probabilidades válido.");
            System.exit(1);
        }

        double nRand = Math.random();
        probAcum = 0.0;

        for (int i = 0; i < probabilidades.length; i++) {
            probAcum += probabilidades[i];
            if (nRand <= probAcum) {
                return elementos[i];
            }
        }
        return elementos[elementos.length - 1];
    }

    public static int generarRandom(final int MIN, final int MAX){
        final int RANGO = MAX - MIN + 1; // [MIN, MAX] incluye ambos
        return (int) (Math.random() * RANGO) + MIN;
    }

}
