/*
 * Universidad del Valle de Guatemala
 * Roberto Barreda - 23354
 */

 public class Traductor {
    private ArbolBinario<Relacion> dictionaryTree;

    public Traductor(ArbolBinario<Relacion> dictionaryTree) {
        this.dictionaryTree = dictionaryTree;
    }

    public String traducir(String palabra) {
        Relacion relacion = dictionaryTree.buscar(new Relacion(palabra.toLowerCase(), ""));
        if (relacion != null) {
            return relacion.getSpanishWord();
        } else {
            return "*" + palabra + "*";
        }
    }
}


