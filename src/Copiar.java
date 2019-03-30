import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Copiar {
    //Atributos
    private static ArrayList<Integer> bytes = new ArrayList<>();
    private static String origen = null;
    private static String copia = null;



    public static void main(String[] args) throws IOException {

        try {
            if(args.length !=2)
                throw new ArgumentosInvalidos();

            else {
                origen = args[0];
                copia = args[1];
                leerArchivo(origen);
            }

        } catch (ArgumentosInvalidos e) {
            System.out.println("Los argumentos introducidos no son correctos.");
            System.out.println("La sintaxis correcta es: java Copiar nombreFichero1 nombreFichero2");
        }
    }


    public static void leerArchivo(String nombreFichero1) {
            boolean final_ar = true;

            try {
                //Creamos el flujo de datos con el archivo
                FileInputStream archivoOrigen = new FileInputStream(nombreFichero1);

                while (final_ar) {
                    int byte_entrada = archivoOrigen.read();

                    if (byte_entrada != -1) {
                        bytes.add(byte_entrada);

                    } else
                        final_ar = false;

                }
                archivoOrigen.close();
                escribirFichero(copia);

            } catch (IOException e) {
                System.out.println("El fichero seleccionado no existe");

            }


        }

        public static void escribirFichero(String nombreFichero2) {


        try {
            //Creamos flujo de dato de salida
            FileOutputStream archivoCopia = new FileOutputStream(nombreFichero2);

            for( int i =0; i < bytes.size(); i++ ) {
                archivoCopia.write(bytes.get(i));
            }
            System.out.println("La copia del fichero " + origen + " se ha realizado con éxito!");
            archivoCopia.close();
        } catch (IOException e) {
            System.out.println("El fichero no se ha podido copiar");
        }


    }
}

//Exceptions//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class ArgumentosInvalidos extends Exception {
    public ArgumentosInvalidos(){
        super();
    }
}