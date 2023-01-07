package Funciones;
/**
   * Ejercicio: Palabrín.
     * @author JohanaPardo 1DAW
   * @version 07.01.2023
   */
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
    /**
     *  Escoger palabra dentro del array "palabraDia".
           * @return  palabra palabra dentro del array.
           */
    public String escogerPalabra() {
        int aleatorio = (int) (Math.random() * 30);
        String palabra = palabraDia[aleatorio];
        return palabra;
    }
    /**
     *  convertir una palabra en un array de char".
     * @parm palabra, bien sea aleatoria del array o introducida por el usuario
     * @return  array de char de la palabra introducida .
     */
    public char[] convertirChar(String palabra) {
            char[] arrayIntro = new char[NUMERO_CARACTER];
            arrayIntro = palabra.toCharArray();
        return arrayIntro;
    }

    /**
     *  Dejar al usuario introducir por consola una palabra".
     * * @return  palabra String palabra introducida por el usuario .
     */
    public String introducirPalabra() {
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
