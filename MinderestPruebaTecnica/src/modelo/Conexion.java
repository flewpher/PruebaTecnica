package modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private static Connection instancia = null;
    private static final String CONFIG_FILE = "db.properties";

    private Conexion() {
    }

    public static Connection getConnect() {
        if (instancia == null) {
            try {
                Properties props = cargarConfiguracion();

                String host = props.getProperty("db.host");
                String port = props.getProperty("db.port");
                String dbname = props.getProperty("db.name");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                String url = "jdbc:mysql://" + host + ":" + port + "/" + dbname;

                instancia = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return instancia;
    }

    private static Properties cargarConfiguracion() throws IOException {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            props.load(input);
        }
        return props;
    }

    public static void cerrarConexion() {
        if (instancia != null) {
            try {
                instancia.close();
                instancia = null;
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
