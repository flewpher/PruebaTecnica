package modelo;

public class Cliente {
    private String nombre;
    private final Long id;

    public Cliente(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }
}
