package controller;

import java.util.ArrayList;
import java.util.List;
import model.Conexion;
import model.producto;

public class Servicio {
    private Conexion conexion;

    public Servicio() {
        this.conexion = new Conexion();
    }

    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO producto (cliente_id, grupo_id, nombre) VALUES (?, ?, ?)";
        try (var conn = Conexion.getConnect();
                var pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, producto.getClienteId());
            pstmt.setLong(2, producto.getGrupoId());
            pstmt.setString(3, producto.getNombre());

            pstmt.executeUpdate();
            System.out.println("Producto insertado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public List<Producto> obtenerProductosEquivalentes(Long clienteID, Producto producto) {
        List<Producto> productosEquivalentes = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE cliente_id != ? AND grupo_id = ? AND id != ?";
        try (var conn = Conexion.getConnect();
                var pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, clienteID);
            pstmt.setLong(2, producto.getGrupoId());
            pstmt.setLong(3, producto.getId());

            var rs = pstmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                Long clienteId = rs.getLong("cliente_id");
                Long grupoId = rs.getLong("grupo_id");

                Producto prod = new producto(id, nombre, clienteId, grupoId);
                productosEquivalentes.add(prod);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return productosEquivalentes;
    }
}
