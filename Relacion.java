/*
 * Universidad del Valle de Guatemala
 * Roberto Barreda - 23354
 */

 public class Relacion implements Comparable<Relacion> {
    private String englishWord;
    private String spanishWord;

    public Relacion(String englishWord, String spanishWord) {
        this.englishWord = englishWord;
        this.spanishWord = spanishWord;
    }
    
    /** 
     * @return String
     */
    public String getEnglishWord() {
        return englishWord;
    }

    public String getSpanishWord() {
        return spanishWord;
    }

    @Override
    public int compareTo(Relacion otraRelacion) {
        // Comparar las palabras en inglés para determinar el orden en el árbol binario
        return this.englishWord.compareTo(otraRelacion.getEnglishWord());
    }
}
