package model;

public class Producto {
    private final Long id;
    private String nombre;
    private Long clienteId;

    public Producto(Long id, String nombre, Long clienteId) {
        this.id = id;
        this.nombre = nombre;
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
