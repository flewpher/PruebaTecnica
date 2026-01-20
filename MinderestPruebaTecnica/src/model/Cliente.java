package model;

public class Cliente {
    private final String nombre;
    private final Long id;
    private final String codigo;

    public Cliente(String nombre, Long id, String codigo) {
        this.nombre = nombre;
        this.id = id;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }
}
