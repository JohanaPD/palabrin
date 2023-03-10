import Funciones.Funciones;

/**
 * Ejercicio: Palabrín.
 *
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
    static final int FALLO = 100;

    public static void main(String[] args) {
        System.out.println("PREPARATE PARA ADIVINAR");
        String palabraHoy = "";
        String palabraEscrita = "";
        int score = 1000;
        int fallo = FALLO;
        boolean juego = true;
        char[] arrayAleat;
        char[] arrayHoy;
        String[] diccionario = usar.diccionario();

        do {
            palabraHoy = usar.escogerPalabra();
            System.out.print(palabraHoy);
            //Convierto palabra aleatoria en array
            arrayAleat = usar.convertirChar(palabraHoy);
            do {
                for (int i = 0; i < FILAS_N; i++) {
                    palabraEscrita = usar.introducirPalabra(diccionario, palabraHoy);
                    arrayHoy = palabraEscrita.toCharArray();
                    System.out.println("\n Puntuación :" + score);
                    if (palabraHoy.equals(palabraEscrita)) {
                       //System.out.println(" Entra en if equals??? ");
                        juego = false;
                        break;
                    } else score = score - FALLO;
                    if (score == 0) {
                        juego = false;
                    }
                    for (int j = 0; j < COLUMNAS_N; j++) {
                        if (arrayHoy[j] == arrayAleat[j]) {
                            System.out.print(ANSI_VERDE + arrayHoy[j] + ANSI_VOLVER_A_BLANCO + " ");
                        } else if (palabraHoy.contains(Character.toString(arrayHoy[j]))) {
                            System.out.print(ANSI_AMARILLO + arrayHoy[j] + ANSI_VOLVER_A_BLANCO + " ");
                        } else {
                            System.out.print(arrayHoy[j] + " ");
                        }
                    }
                }
            } while (juego || score==0);
           // System.out.println("salida 1 de juego");
            if (score == 0) {
                System.out.println("Has perdido");
            } else {
                System.out.println("HAZ GANADO");
                System.out.println("tu puntuacion es de: " + score);
                juego = false;
            }
        } while (juego);
       // System.out.println("salida 2 de juego");
    }
}