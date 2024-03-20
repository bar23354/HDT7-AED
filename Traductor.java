/*
 * Universidad del Valle de Guatemala
 * Roberto Barreda - 23354
 */

public class Traductor {
    private ArbolBinario<String, String> dictionaryTree;

    public Traductor(ArbolBinario dictionaryTree) {
        this.dictionaryTree = dictionaryTree;
    }

    /** 
     * @param texto
     * @return String
     */
    public String traducirTexto(String texto) {
        StringBuilder resultado = new StringBuilder();
        String[] palabras = texto.split("\\s+");
        for (String palabra : palabras) {
            String traduccion = dictionaryTree.buscar(palabra.toLowerCase());
            if (traduccion != null) {
                resultado.append(traduccion).append(" ");
            } else {
                resultado.append("*").append(palabra).append("* ");
            }
        }
        return resultado.toString().trim();
    }
}

    

