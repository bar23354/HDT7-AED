/*
 * Universidad del Valle de Guatemala
 * Roberto Barreda - 23354
 */
 
 public class MerriamWebster {
    public static void main(String[] args) {
        ArbolBinario<Relacion> dictionaryTree = Lee.leerDiccionario("diccionario.txt");

        Lee.traducirTexto(dictionaryTree, "texto.txt");
    }
}