package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarritoTest {

    @Test
    void carritoRecienCreadoEstaVacio() {
        Carrito carrito = new Carrito();
        assertTrue(carrito.estaVacio());
    }

    @Test
    void cantidadDeProductosDespuesDeAgregarUno() {
        Carrito carrito = new Carrito();
        Producto producto = new Producto("cuaderno", 1.50, 10);
        carrito.agregar(producto);
        assertEquals(1, carrito.cantidadDeProductos());
    }

    @Test
    void totalConDosProductosEsLaSumaDeSusPrecios() {
        Carrito carrito = new Carrito();
        carrito.agregar(new Producto("morral", 1.50, 10));
        carrito.agregar(new Producto("cartuchera", 2.00, 5));
        assertEquals(3.50, carrito.calcularTotal());
    }

    @Test
    void carritoConUnProductoNoEstaVacio() {
        Carrito carrito = new Carrito();
        carrito.agregar(new Producto("lapiz", 0.80, 3));
        assertFalse(carrito.estaVacio());
    }

    @Test
    void totalDeCarritoVacioEsCero() {
        Carrito carrito = new Carrito();
        assertEquals(0.0, carrito.calcularTotal());
    }

    @Test
        // acumula con más de un producto
    void cantidadDeProductosConVariosProductos() {
        Carrito carrito = new Carrito();
        carrito.agregar(new Producto("Morral", 1.50, 10));
        carrito.agregar(new Producto("cuaderno", 2.00, 5));
        carrito.agregar(new Producto("lapez", 3.00, 8));
        assertEquals(3, carrito.cantidadDeProductos());
    }
}