import controller.Servicio;
import java.util.List;
import model.Producto;

public class App {
    public static void main(String[] args) {
        Servicio servicio = new Servicio();
        // servicio.listarProductos();
        Producto producto1 = new Producto(1L, "Leche entera marca A", 1L);

        List<Producto> equivalentes = servicio.obtenerProductosEquivalentes(1L,
                producto1);
        for (Producto p : equivalentes) {
            System.out.println(p.getNombre() + " ID: " + p.getId());
        }

        // Producto producto2 = new Producto(14L, "Leche entera MismaMarca", 3L);
        // servicio.insertarProducto(producto2);
        // servicio.listarProductos();
        // servicio.crearEquivalencia(producto1, producto2);

        /**
         * List<Producto> equivalentes = servicio.obtenerProductosEquivalentes(1L,
         * producto1);
         * for (Producto p : equivalentes) {
         * System.out.println(p.getNombre() + " ID: " + p.getId());
         * }
         */
    }
}
