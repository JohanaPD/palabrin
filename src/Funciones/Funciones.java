package Funciones;
/**
 * @nombre: Funciones.Palabrín.
 * @author JohanaPardo, Fernando García 1DAW
 * @version 07.01.2023
 */

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;


public class Funciones {
    public static int NUMERO_CARACTER = 8;
    static final int NUMERO_DICCIONARIO = 73252;
    static Scanner sc = new Scanner(System.in);
    String[] diccionario = new String[NUMERO_DICCIONARIO];
    int iv = 0;
    public static String[] palabraDia = {"anatemas", "amuletos", "balbuceos", "baldosas", "censores", "centavos",
            "distingo", "diversos", "escápula", "esférica", "factores", "faraones",
            "Germania", "gestando", "halógeno", "haraposo", "inéditos", "inútiles",
            "Jordania", "jornales", "kuwaitís", "káiseres", "lucrosos", "Luisiana",
            "monarcas", "ocelotes", "racistas", "soñadora", "trajeran", "virreyes"
    };

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
        String palabra = palabraDia[aleatorio];
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
    public String introducirPalabra(String[] diccionario) {
        //Pruebas de diccionario ok, carga ok
        String palabra;
        boolean boo = true;
        sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Introduce una palabra para buscar en el diccionario");
        do {
            palabra = sc.nextLine();
            palabra = palabra.trim();
            palabra = palabra.toUpperCase();

           if (palabra.length() < NUMERO_CARACTER || palabra.length() > NUMERO_CARACTER) {
                System.out.println("La palabra no tiene el número de letras solicitado");
            } else if (palabra.equals("POKE")) {
                System.out.println("ENTRANDO EN POKE");
                boo = false; //función Fer
            }  else if (Arrays.binarySearch(diccionario, palabra) < 0) {
                System.out.println("La palabra " + palabra + " no se encuentra en el diccionario");
            }else {
                System.out.println(palabra + " se encuentra en el diccionario");
            }
        } while (palabra.length() != NUMERO_CARACTER && Arrays.binarySearch(diccionario, palabra) < 0 || boo == false); /*&& Arrays.binarySearch(diccionario, palabra) < 0) */
        if (!palabra.equals("POKE")) {
            System.out.println(palabra + " se encuentra en el diccionario");
        }
        return palabra;
    }


}
