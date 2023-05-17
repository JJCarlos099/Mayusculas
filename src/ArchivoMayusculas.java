import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArchivoMayusculas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();

        System.out.println("Ingrese el texto en mayúsculas (escriba 'fin' para terminar): ");

        try (FileWriter archivo = new FileWriter(nombreArchivo + ".txt")) {
            String linea;

            while (true) {
                linea = scanner.nextLine();

                if (linea.equalsIgnoreCase("fin")) {
                    break;
                }

                if (!linea.equals(linea.toUpperCase())) {
                    System.out.println("Error: Solo se permiten caracteres en mayúscula. Intenta nuevamente");
                    continue;
                }

                archivo.write(linea);
                archivo.write(System.lineSeparator());
            }

            System.out.println("Archivo creado correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

