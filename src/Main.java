import Funciones.Funciones;

/**
 * Ejercicio: Palabrín.
 * @author JohanaPardo, Fernando García 1DAW
 * @version 07.01.2023
 */
public class Main {
    static Funciones usar = new Funciones();
    static int FILAS_N = 10;
    static int COLUMNAS_N = 8;
    public static final String ANSI_VOLVER_A_BLANCO = "\u001B[0m";
    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_AMARILLO = "\u001B[33m";
    static final int SCORE = 1000;
    static final int FALLO = 100;

    public static void main(String[] args) {
        System.out.println("PREPARATE PARA ADIVINAR");

        String palabraHoy = "";
        String palabraEscrita = "";
        String palabraWin = "VICTORIA";
        char[] arrayAleat;
        char[] arrayHoy;
        char[] victoria = usar.convertirChar(palabraWin);
        int contador = 0;
        int score = SCORE;
        int fallo = FALLO;
        boolean juego = true;

        String[] diccionario = usar.diccionario();
        do {
            palabraHoy = usar.escogerPalabra().toUpperCase();
            System.out.println(palabraHoy);
            arrayAleat = new char[palabraHoy.length()];
            //Convierto palabra aleatoria en array
            arrayAleat = usar.convertirChar(palabraHoy);
            do {

                palabraEscrita = usar.introducirPalabra(diccionario).toUpperCase();
                arrayHoy = palabraEscrita.toCharArray();
                System.out.println(palabraEscrita);
                contador++;


                for (int j = 0; j < COLUMNAS_N; j++) {
                    if (palabraEscrita.equals("POKE")) {
                        int numero = (int) (Math.random() * palabraEscrita.length() - 1);
                        System.out.println(arrayHoy[numero]);
                    } else if (arrayHoy[j] == arrayAleat[j]) {
                        System.out.print(ANSI_VERDE + arrayHoy[j] + ANSI_VOLVER_A_BLANCO + " ");

                    } else if (palabraHoy.contains(Character.toString(arrayHoy[j]))) {

                        System.out.print(ANSI_AMARILLO + arrayHoy[j] + ANSI_VOLVER_A_BLANCO + " ");
                    } else {
                        System.out.print(arrayHoy[j] + " ");
                    }


                }


                if (palabraHoy.equals(palabraEscrita)) {
                    System.out.println();
                    juego = false;
                } else score = score - fallo;
                if (score == 0) {
                    juego = false;
                }

                System.out.println("Tu puntuación " + score);

            } while (juego == true);
            if (score == 0) {
                System.out.println("Has perdido");
            } else {
                System.out.println("HAZ GANADO");
                System.out.println("tu puntuacion es de: " + score);
                juego = false;
            }


        }while (juego == true) ;
    }
}