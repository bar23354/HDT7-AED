/*
 * Universidad del Valle de Guatemala
 * Roberto Barreda - 23354
 */
 
 public class ArbolBinario<K extends Comparable<K>, V> {
    private Nodo<K, V> raiz;

    private static class Nodo<K, V> {
        K clave;
        V valor;
        Nodo<K, V> izquierdo;
        Nodo<K, V> derecho;

        Nodo(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public ArbolBinario() {
        raiz = null;
    }

    /** 
     * @param clave
     * @param valor
     */
    public void insertar(K clave, V valor) {
        raiz = insertarNodo(raiz, clave, valor);
    }

    private Nodo<K, V> insertarNodo(Nodo<K, V> nodo, K clave, V valor) {
        if (nodo == null) {
            return new Nodo<>(clave, valor);
        }
        int comparacion = clave.compareTo(nodo.clave);
        if (comparacion < 0) {
            nodo.izquierdo = insertarNodo(nodo.izquierdo, clave, valor);
        } else if (comparacion > 0) {
            nodo.derecho = insertarNodo(nodo.derecho, clave, valor);
        } else {
            nodo.valor = valor; // Actualiza el valor si la clave ya existe
        }
        return nodo;
    }

    public V buscar(K clave) {
        if (clave == null) {
            return null;
        }
        return buscarNodo(raiz, clave);
    }    

    private V buscarNodo(Nodo<K, V> nodo, K clave) {
        if (nodo == null) {
            return null;
        }
        int comparacion = clave.compareTo(nodo.clave);
        if (comparacion == 0) {
            return nodo.valor;
        } else if (comparacion < 0) {
            return buscarNodo(nodo.izquierdo, clave);
        } else {
            return buscarNodo(nodo.derecho, clave);
        }
    }
}
