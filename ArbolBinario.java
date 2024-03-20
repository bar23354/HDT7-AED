/*
 * Universidad del Valle de Guatemala
 * Roberto Barreda - 23354
 */

 public class ArbolBinario<E extends Comparable<E>> {
    private Nodo<E> raiz;

    private static class Nodo<E> {
        E valor;
        Nodo<E> izquierdo;
        Nodo<E> derecho;

        Nodo(E valor) {
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(E valor) {
        raiz = insertarNodo(raiz, valor);
    }

    private Nodo<E> insertarNodo(Nodo<E> nodo, E valor) {
        if (nodo == null) {
            return new Nodo<>(valor);
        }
        if (valor.compareTo(nodo.valor) < 0) {
            nodo.izquierdo = insertarNodo(nodo.izquierdo, valor);
        } else if (valor.compareTo(nodo.valor) > 0) {
            nodo.derecho = insertarNodo(nodo.derecho, valor);
        }
        return nodo;
    }

    public E buscar(E valor) {
        return buscarNodo(raiz, valor);
    }

    private E buscarNodo(Nodo<E> nodo, E valor) {
        if (nodo == null) {
            return null;
        }
        if (valor.equals(nodo.valor)) {
            return nodo.valor;
        }
        if (valor.compareTo(nodo.valor) < 0) {
            return buscarNodo(nodo.izquierdo, valor);
        }
        return buscarNodo(nodo.derecho, valor);
    }

    public void recorridoInOrder() {
        recorridoInOrder(raiz);
    }

    private void recorridoInOrder(Nodo<E> nodo) {
        if (nodo != null) {
            recorridoInOrder(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            recorridoInOrder(nodo.derecho);
        }
    }
}