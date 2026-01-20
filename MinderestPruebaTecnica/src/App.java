import controller.Servicio;
import model.Producto;

public class App {
    public static void main(String[] args) {

        /*
         * Conexion conexion = new Conexion();
         * String sql = "SELECT * FROM producto";
         * 
         * try (var conn = Conexion.getConnect();
         * var stmt = conn.createStatement();
         * var rs = stmt.executeQuery(sql)) {
         * 
         * while (rs.next()) {
         * System.out.println(
         * "ID: " + rs.getInt("producto.id_producto") + ", Nombre: " +
         * rs.getString("producto.nombre"));
         * }
         * } catch (Exception e) {
         * System.err.println(e.getMessage());
         * }
         */

        Producto producto = new Producto(null, "prueba", 1L, 2L);
        System.out.println(producto);
        Servicio servicio = new Servicio();
        // servicio.insertarProducto(producto);
        /*
         * servicio.obtenerProductosEquivalentes(1L, producto).forEach(p -> {
         * System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre() +
         * ", Cliente ID: " + p.getClienteId()
         * + ", Grupo ID: " + p.getGrupoId());
         * });
         */
    }
}
