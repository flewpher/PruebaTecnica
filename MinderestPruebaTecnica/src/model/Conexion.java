package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private static Connection instancia = null;
    private static final String ARCHIVO = "db.properties";

    public Conexion() {
    }

    public static Connection getConnect() {
        if (instancia == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");

                Properties props = cargarConfiguracion();

                String host = props.getProperty("db.host");
                String port = props.getProperty("db.port");
                String dbname = props.getProperty("db.name");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                String url = "jdbc:mariadb://" + host + ":" + port + "/" + dbname;

                instancia = DriverManager.getConnection(url, user, password);

                if (instancia != null) {
                    // System.out.println("[DEBUG] Conexión establecida: " + instancia);
                } else {
                    // System.out.println("[DEBUG] DriverManager.getConnection devolvió null");
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return instancia;
    }

    private static Properties cargarConfiguracion() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(ARCHIVO)) {
            props.load(input);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return props;
    }

}
