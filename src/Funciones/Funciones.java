package Funciones;

import java.util.Scanner;

public class Funciones {
    public static int NUMERO_CARACTER = 8;
    static Scanner sc = new Scanner(System.in);
    String[] arrayEscoger = new String[31];
    /*Pedir palabra*/

    public String escogerPalabra() {
        int aleatorio = (int) (Math.random() * 31 + 1);
        String palabra = arrayEscoger[aleatorio];
        return palabra;
    }

    public char[] convertirChar(String palabra, char[] arrayChar) {
         arrayChar = new char[NUMERO_CARACTER];
        arrayChar = palabra.toCharArray();
        return arrayChar;
    }

    public String introducirPalabra() {
        System.out.println("Introduzca una palabra real de  8 letras ");
        String palabra;
        do {
            palabra = sc.nextLine();
            palabra.trim().toUpperCase();
            if (palabra.length() < NUMERO_CARACTER || palabra.length() > NUMERO_CARACTER) {
                System.out.println("La palabra no tiene el número de letras solicitado");
            }
        } while(palabra.length() != NUMERO_CARACTER);
        return palabra;
    }


}

