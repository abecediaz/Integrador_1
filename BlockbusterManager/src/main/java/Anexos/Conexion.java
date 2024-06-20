package Anexos;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static String url = "jdbc:mysql://127.0.0.1:3306/blockbuster";
    static String user = "root";
    static String password = "";
    static Connection connection = null;

    public static Connection conectar() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
