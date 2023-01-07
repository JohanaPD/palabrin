import Funciones.Funciones;

public class Main {
    static Funciones usar = new Funciones();
    static int FILAS_N = 10;
    static int COLUMNAS_N = 8;

    public static void main(String[] args) {
        System.out.println("PREPARATE PARA ADIVINAR");

        String palabraHoy = "";
        String palabraEscrita = "";
        char[] arrayAleat;
        char[] arrayHoy;
        int contador = 0;
        do {
            palabraHoy = usar.escogerPalabra().toUpperCase();
            //Unicamente para verificar que coge la palabra, luego eliinar
            System.out.println(palabraHoy);
            arrayAleat = new char[palabraHoy.length()];
            //Convierto palabra aleatoria en array
            arrayAleat = usar.convertirChar(palabraHoy);

            do {
                palabraEscrita = usar.introducirPalabra().toUpperCase();
                arrayHoy = palabraEscrita.toCharArray();
                contador++;
                for (int i = 0; i < FILAS_N; i++) {
                    for (int j = 0; j < COLUMNAS_N; j++) {
                        System.out.print(" " + arrayHoy[j] + " ");
                    }
                    System.out.println();
                }
            } while (contador == COLUMNAS_N);

        } while (palabraHoy.equals(""));

    }
}