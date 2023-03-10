package Funciones;
/**
 * @nombre: Funciones.Palabrín.
 * @author JohanaPardo, Fernando García 1DAW
 * @version 07.01.2023
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;


public class Funciones {
    static Scanner sc = new Scanner(System.in);
    public static int NUMERO_CARACTER = 8;
    static final int NUMERO_DICCIONARIO = 73252;
    static final String PALABRA_PISTA = "poke";
    public static int PISTAS = 3;
    int pista = 0;
    String palabraReply = "";
    String[] diccionario = new String[NUMERO_DICCIONARIO];
    char[] arrayPista = new char[NUMERO_CARACTER];
    char[] arrayIntro = new char[NUMERO_CARACTER];
    char[] arrayHoy;
    char[] arrayAleat = new char[PISTAS];
    int iv = 0;

    public String[] diccionario() {
        try {
            sc = new Scanner(new FileReader("resources/palabras.txt"));
            String str;
            while (sc.hasNext()) {
                str = sc.next();
                diccionario[iv] = str;
                iv++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
        } finally {
            sc.close();
        }
        return diccionario;
    }

    /**
     * Escoger palabra dentro del array "palabraDia".
     *
     * @return palabra palabra dentro del array.
     */
    public String escogerPalabra() {
        int aleatorio = (int) (Math.random() * 30);
        String palabra = diccionario[aleatorio].trim().toUpperCase();
        return palabra;
    }

    /**
     * convertir una palabra en un array de char".
     *
     * @param palabra, bien sea aleatoria del array o introducida por el usuario
     * @return array de char de la palabra introducida .
     */
    public char[] convertirChar(String palabra) {
        char[] arrayIntro = new char[NUMERO_CARACTER];
        arrayIntro = palabra.toCharArray();
        return arrayIntro;
    }

    /**
     * Dejar al usuario introducir por consola una palabra".
     *
     * @return palabra String palabra introducida por el usuario .
     */
    public String introducirPalabra(String[] diccionario, String palabraH) {
        String palabra;
        String palabraHoy = palabraH;
        boolean boo = true;
        Arrays.sort(diccionario);
        sc = new Scanner(System.in);
        System.out.println("\n Introduce una palabra para buscar en el diccionario\n");
        do {
            palabra = sc.nextLine();
            palabra = palabra.trim();
            if (palabra.equals("poke")) {
                poke(palabra, palabraHoy, PALABRA_PISTA, PISTAS, pista);
                pista++;
                boo = false;
            } else if (palabra.length() < NUMERO_CARACTER || palabra.length() > NUMERO_CARACTER) {
                System.out.println("La palabra no tiene el número de letras solicitado");
            } else if (Arrays.binarySearch(diccionario, palabra) < 0) {
                System.out.println("La palabra " + palabra + " no se encuentra en el diccionario");
            } else {
                System.out.println(palabra + " se encuentra en el diccionario");
            }
        } while (palabra.length() != NUMERO_CARACTER && Arrays.binarySearch(diccionario, palabra) < 0 || boo == false); /*&& Arrays.binarySearch(diccionario, palabra) < 0) */
        palabra = palabra.toUpperCase();
        return palabra;
    }

    /**
     * Escoger la pista a dar al usuario una vez este la solicita.
     *
     * @param array Pista char Array con la palabra del día que elegirá 3 letras para dar.
     */
    public void darPista(char[] arrayPista) {
        int aleat;
        String letra = "";
        do {
            aleat = (int) (Math.random() * NUMERO_CARACTER);
            if ((letra.isEmpty())) {
                for (int i = 0; i < PISTAS; i++) {
                    letra = (char) arrayPista[aleat] + "";
                    if (arrayAleat[i] == 0 || !((arrayAleat[i] + "") == letra)) {
                        arrayAleat[i] = arrayPista[aleat];
                    } else {
                        arrayAleat[i] = arrayAleat[i];
                    }
                }
                System.out.println("Pista " + letra + " ");
            }
        } while (!letra.contains(""));
    }

    /**
     * Escoger la pista a dar al usuario una vez este la solicita.
     *
     * @param variable1 string con la palabra facilitada por el usuario
     * @param variable2 string con la palabra escogída aleatoriamente
     * @param variable3 constante con la palabra para pedir pista
     * @param pistas    constante con el número de pistas que tiene un usuario en cada juego
     * @param Pista     variable numérica que cuenta las pistas usadas en el juego
     */
    public void poke(String palabraEscrita, String palabraHoy, String PALABRA_PISTA, int PISTAS, int pista) {
        if (palabraEscrita.equals(PALABRA_PISTA)) {
            if (pista >= PISTAS) {
                System.out.println("No se pueden dar mas pistas");

            } else {
                arrayPista = convertirChar(palabraHoy);
                darPista(arrayPista);

            }
            pista = pista + 1;
            palabraEscrita=introducirPalabra(diccionario,  palabraHoy);
        }

    }


}