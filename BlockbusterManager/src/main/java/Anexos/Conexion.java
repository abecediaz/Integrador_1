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
            System.out.println("LA CONEXIÓN FUE EXITOSA");
        }
        catch (Exception e) {
            System.out.println("HUBO UN ERROR EN LA CONEXIÓN");
            e.printStackTrace();
        }
        return connection;
    }
}
