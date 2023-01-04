import Funciones.Funciones;

public class Main {
    static Funciones usar = new Funciones();
    static int FILAS_N = 10;
    static int COLUMNAS_N = 8;

    public static void main(String[] args) {
        System.out.println("PREPARATE PARA ADIVINAR");
        String palabraHoy="";
        char[] arrayAleat;
        do {
            palabraHoy=usar.escogerPalabra();
            //Unicamente para verificar que coge la palabra, luego eliinar
            System.out.println(palabraHoy);
            arrayAleat= new char[palabraHoy.length()];
            //Convierto palabra aleatoria en array
            arrayAleat=usar.convertirChar(palabraHoy);

            for (int i = 0; i < COLUMNAS_N; i++) {
                for (int j = 0; j < FILAS_N; j++) {
                    System.out.print(" _ ");
                }
                System.out.println();
            }
        } while (palabraHoy.equals(""));

    }
}