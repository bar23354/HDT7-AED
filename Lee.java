/*
 * Universidad del Valle de Guatemala
 * Roberto Barreda - 23354
 */

 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 
 public class Lee {
     
     /** 
      * @param nombreArchivo
      * @return ArbolBinario<String, String>
      */
     public static ArbolBinario<String, String> leerDiccionario(String nombreArchivo) {
         ArbolBinario<String, String> dictionaryTree = new ArbolBinario<>();
         try {
             BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
             String line;
             while ((line = reader.readLine()) != null) {
                 String[] parts = line.split(",");
                 String englishWord = parts[0].trim().substring(1).toLowerCase();
                 String spanishWord = parts[1].trim().substring(0, parts[1].trim().length() - 1);
                 dictionaryTree.insertar(englishWord, spanishWord);
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
 
     public static void traducirTexto(ArbolBinario<String, String> dictionaryTree, String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder translatedLine = new StringBuilder();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String cleanedWord = cleanWord(word);
                    String translation = dictionaryTree.buscar(cleanedWord.toLowerCase());
                    if (translation != null) {
                        translatedLine.append(translation).append(" ");
                    } else {
                        translatedLine.append("*").append(cleanedWord).append("* ");
                    }
                }
                System.out.println(translatedLine.toString().trim());
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }

    private static String cleanWord(String word) {
        // Eliminar signos de puntuación pegados a la palabra
        String cleanedWord = word.replaceAll("[^a-zA-Z\\s]", "");
        // Eliminar espacios en blanco al inicio y al final de la palabra
        return cleanedWord.trim();
    }
}
 