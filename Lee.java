/*
 * Universidad del Valle de Guatemala
 * Roberto Barreda - 23354
 */

 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 
 public class Lee {
    public static ArbolBinario<Relacion> leerDiccionario(String nombreArchivo) {
        ArbolBinario<Relacion> dictionaryTree = new ArbolBinario<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String englishWord = parts[0].trim().substring(1);
                String spanishWord = parts[1].trim().substring(0, parts[1].trim().length() - 1);
                Relacion relacion = new Relacion(englishWord, spanishWord);
                dictionaryTree.insertar(relacion);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
        }
        return dictionaryTree;
    }

    public static String[] leerTextoPalabras(String nombreArchivo) {
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
        }
        return text.toString().trim().split("\\s+");
    }

    public static void traducirTexto(ArbolBinario<Relacion> dictionaryTree, String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                StringBuilder translatedLine = new StringBuilder();
                for (String word : words) {
                    Relacion relacion = dictionaryTree.buscar(new Relacion(word.toLowerCase(), ""));
                    if (relacion != null) {
                        translatedLine.append(relacion.getSpanishWord()).append(" ");
                    } else {
                        translatedLine.append("*").append(word).append("* ");
                    }
                }
                System.out.println(translatedLine.toString().trim());
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
}