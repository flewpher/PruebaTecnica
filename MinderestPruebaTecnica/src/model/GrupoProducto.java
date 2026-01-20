package model;

public class GrupoProducto {
    private final Long id;
    private String nombre;

    public GrupoProducto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
