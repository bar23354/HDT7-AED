/*
 * Universidad del Valle de Guatemala
 * Roberto Barreda - 23354
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MerriamWebster {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        ArbolBinario dictionaryTree = Lee.leerDiccionario("diccionario.txt");
        Traductor traductor = new Traductor(dictionaryTree);
        
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String lineaTraducida = traductor.traducirTexto(linea);
                System.out.println(lineaTraducida);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
