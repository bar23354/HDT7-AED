import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class ArbolBinarioTest {
    private ArbolBinario<String, String> arbol;

    @Before
    public void setUp() {
        arbol = new ArbolBinario<>();
    }

    @Test
    public void testInsertarYBuscar() {
        arbol.insertar("casa", "casa");
        arbol.insertar("perro", "perro");
        arbol.insertar("gato", "gato");
        arbol.insertar("árbol", "árbol");

        assertEquals("casa", arbol.buscar("casa"));
        assertEquals("perro", arbol.buscar("perro"));
        assertEquals("gato", arbol.buscar("gato"));
        assertEquals("árbol", arbol.buscar("árbol"));
    }

    @Test
    public void testBuscarNoExistente() {
        arbol.insertar("casa", "casa");
        arbol.insertar("perro", "perro");
        arbol.insertar("gato", "gato");

        assertNull(arbol.buscar("hola"));
        assertNull(arbol.buscar("mundo"));
        assertNull(arbol.buscar("manzana"));
    }

    @Test
    public void testInsertarNulos() {
        arbol.insertar(null, null);
        assertNull(arbol.buscar(null));
    }

    @Test
    public void testInsertarYBuscarEnArbolVacio() {
        assertNull(arbol.buscar("casa"));
        assertNull(arbol.buscar("perro"));
        assertNull(arbol.buscar("gato"));
        assertNull(arbol.buscar("árbol"));
    }
}
