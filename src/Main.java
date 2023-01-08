import Funciones.Funciones;

/**
 * Ejercicio: Palabrín.
 *
 * @author JohanaPardo 1DAW
 * @version 07.01.2023
 */
public class Main {
    static Funciones usar = new Funciones();
    static int FILAS_N = 10;
    static int COLUMNAS_N = 8;
    public static final String ANSI_VOLVER_A_BLANCO = "\u001B[0m";
    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_AMARILLO = "\u001B[33m";
    static final int SCORE= 1000;

    public static void main(String[] args) {
        System.out.println("PREPARATE PARA ADIVINAR");

        String palabraHoy = "";
        String palabraEscrita = "";
        String palabraWin="VICTORIA";
        char[] arrayAleat;
        char[] arrayHoy;
        char[] victoria= usar.convertirChar(palabraWin);
        int contador = 0;
        do {
            palabraHoy = usar.escogerPalabra().toUpperCase();
            //Unicamente para verificar que coge la palabra, luego eliinar
            System.out.println(palabraHoy);
            arrayAleat = new char[palabraHoy.length()];
            //Convierto palabra aleatoria en array
            arrayAleat = usar.convertirChar(palabraHoy);
            System.out.println("Introduzca una palabra real de  8 letras ");
            do {

                for (int i = 0; i < FILAS_N; i++) {
                    palabraEscrita = usar.introducirPalabra().toUpperCase();
                    arrayHoy = palabraEscrita.toCharArray();
                    contador++;

                    for (int j = 0; j < COLUMNAS_N; j++) {
                        String imprimir = "";
                        if (arrayHoy[j] == arrayAleat[j]) {
                            imprimir = " " + arrayHoy[j] + "** ";
                        } else if (palabraHoy.contains(Character.toString(arrayHoy[j]))) {
                            imprimir = " " + arrayHoy[j] + "* ";
                        }else if(palabraHoy.equals(palabraEscrita)){
                            System.out.println(victoria[j]);
                        } else {
                            imprimir = " " + arrayHoy[j] + " ";
                        }
                        System.out.print(imprimir);

                    }

                }
                System.out.println();
            }
            while (contador == COLUMNAS_N);

        } while (palabraHoy.equals(""));

    }
}