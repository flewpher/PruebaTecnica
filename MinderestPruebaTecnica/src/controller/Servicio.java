package controller;

import java.util.ArrayList;
import java.util.List;
import model.Conexion;
import model.Producto;

public class Servicio {
    private Conexion conexion;

    public Servicio() {
        this.conexion = new Conexion();
    }

    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO producto (cliente_id, nombre) VALUES (?, ?)";
        try (var conn = Conexion.getConnect();
                var pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, producto.getClienteId());
            pstmt.setString(2, producto.getNombre());

            pstmt.executeUpdate();
            System.out.println("Producto insertado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void crearEquivalencia(Producto productoA, Producto productoB) {
        String sql = "INSERT INTO producto_equivalencia (producto_a, producto_b) VALUES (?, ?)";
        try (var conn = Conexion.getConnect();
                var pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, productoA.getId());
            pstmt.setLong(2, productoB.getId());

            pstmt.executeUpdate();
            System.out.println("Equivalencia creada");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Producto> obtenerProductosEquivalentes(Long clienteID, Producto producto) {
        List<Producto> productosEquivalentes = new ArrayList<>();

        String sql = "WITH RECURSIVE eqs(id) AS ("
                + " SELECT ?"
                + " UNION"
                + " SELECT CASE WHEN pe.producto_a = e.id THEN pe.producto_b ELSE pe.producto_a END"
                + " FROM producto_equivalencia pe JOIN eqs e ON (pe.producto_a = e.id OR pe.producto_b = e.id)"
                + ") "
                + "SELECT DISTINCT p.id_producto AS id, p.nombre, p.cliente_id "
                + "FROM producto p JOIN eqs ON p.id_producto = eqs.id "
                + "WHERE p.id_producto <> ?";

        try (var conn = Conexion.getConnect();
                var pstmt = conn.prepareStatement(sql)) {

            long id = producto.getId();
            pstmt.setLong(1, id);
            pstmt.setLong(2, id);

            var rs = pstmt.executeQuery();
            while (rs.next()) {
                Long idRes = rs.getLong("id");
                String nombre = rs.getString("nombre");
                Long clienteId = rs.getLong("cliente_id");

                if (clienteID != null && clienteId.equals(clienteID))
                    continue;

                productosEquivalentes.add(new Producto(idRes, nombre, clienteId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productosEquivalentes;
    }

    public void listarProductos() {
        String sql = "SELECT id_producto, nombre, cliente_id FROM producto";
        try (var conn = Conexion.getConnect();
                var pstmt = conn.prepareStatement(sql);
                var rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("id_producto");
                String nombre = rs.getString("nombre");
                Long clienteId = rs.getLong("cliente_id");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Cliente ID: " + clienteId);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
