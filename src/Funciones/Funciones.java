package Funciones;
/**
 * @nombre: Palabrín.
 * @author JohanaPardo 1DAW
 * @version 07.01.2023
 */

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Scanner;


public class Funciones {
    public static int NUMERO_CARACTER = 8;
    static final int NUMERO_DICCIONARIO = 73252;
    static Scanner sc = new Scanner(System.in);
    String[] diccionario = new String[NUMERO_DICCIONARIO];

    public static String[] palabraDia = {"anatemas", "amuletos", "balbuceos", "baldosas", "censores", "centavos",
            "distingo", "diversos", "escápula", "esférica", "factores", "faraones",
            "Germania", "gestando", "halógeno", "haraposo", "inéditos", "inútiles",
            "Jordania", "jornales", "kuwaitís", "káiseres", "lucrosos", "Luisiana",
            "monarcas", "ocelotes", "racistas", "soñadora", "trajeran", "virreyes"
    };


    /*Pedir palabra*/

    /**
     * Escoger palabra dentro del array "palabraDia".
     */


    public String[] cargarDiccionario() {
            /*int iv = 0;
            try {
                // Cargamos el fichero txt guardado en la carpeta del proyecto
                File fichero = new File("E:\\IES_INFANTA_ELENA\\PROGRAMACION\\intelJ\\Palabrin\\src\\palabras.txt");
                sc = new Scanner(new FileReader(fichero));
                String str;
                //repetir hasta terminar de leer el fichero
                while (sc.hasNext()) {
                    str = sc.next();
                    // añadir palabra al diccionario
                    diccionario[iv] = str;
                    iv++;
                }
            } catch (FileNotFoundException e) {
                // asegurarse que la ruta y el nombre del fichero son correctos
                System.err.println("Fichero no encontrado");
            }finally {
                sc.close();
            }
            */

        String fileName = "C:\\Users\\Fernando\\IdeaProjects\\palabrin\\src\\palabras.txt";

        // Lista donde se almacenarán las palabras
        List<String> palabras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Agregamos la línea a la lista
                palabras.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convertimos la lista a un array
        diccionario = palabras.toArray(new String[NUMERO_DICCIONARIO]);

        // Imprimimos el array
        return  diccionario;

    }

    public String escogerPalabra() {
        int aleatorio = (int) (Math.random() * NUMERO_DICCIONARIO);
        diccionario=cargarDiccionario();
        String palabra = diccionario[aleatorio];
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
    public String introducirPalabra() {
        String palabra;
        do {

            palabra = sc.nextLine();
            palabra.trim().toUpperCase();

            if (palabra.length() < NUMERO_CARACTER || palabra.length() > NUMERO_CARACTER) {
                System.out.println("La palabra no tiene el número de letras solicitado");
            }
        } while (palabra.length() != NUMERO_CARACTER);
        return palabra;
    }


}