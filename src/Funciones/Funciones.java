package Funciones;

import java.util.Scanner;

public class Funciones {
    public static int NUMERO_CARACTER = 8;
    static Scanner sc = new Scanner(System.in);

    public static String [] palabraDia= {"anatemas", "amuletos", "balbuceos", "baldosas", "censores", "centavos",
            "distingo", "diversos", "escápula", "esférica", "factores", "faraones",
            "Germania", "gestando", "halógeno", "haraposo", "inéditos", "inútiles",
            "Jordania", "jornales", "kuwaitís", "káiseres", "lucrosos", "Luisiana",
            "monarcas", "ocelotes", "racistas", "soñadora", "trajeran", "virreyes"
    };


    /*Pedir palabra*/

    public String escogerPalabra() {
        int aleatorio = (int) (Math.random() * 30);
        String palabra = palabraDia[aleatorio];
        return palabra;
    }

    public char[] convertirChar(String palabra) {
            char[] arrayIntro = new char[NUMERO_CARACTER];
            arrayIntro = palabra.toCharArray();
        return arrayIntro;
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
