package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    @Test
    void precioIgualAlDelConstructor() {
        Producto producto = new Producto("cuaderno", 1.50, 10);
        assertEquals(1.50, producto.getPrecio());
    }

    @Test
    void productoConStockMayorACeroEstaDisponible() {
        Producto producto = new Producto("lapiz", 2.00, 5);
        assertTrue(producto.estaDisponible());
    }

    @Test
    void productoConStockCeroNoEstaDisponible() {
        Producto producto = new Producto("borrador", 3.00, 0);
        assertFalse(producto.estaDisponible());
    }

    @Test
    void reducirStockCantidadValida() {
        Producto producto = new Producto("portaminas", 0.80, 10);
        producto.reducirStock(4);
        assertEquals(6, producto.getStock());
    }

    @Test
    void reducirStockMasDelDisponibleLanzaExcepcion() {
        Producto producto = new Producto("cartuchera", 0.50, 3);
        assertThrows(IllegalArgumentException.class, () -> producto.reducirStock(5));
    }

    @Test
    void precioNegativoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> new Producto("morral", -1.00, 10));
    }
}