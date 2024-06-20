package PatronDAO;
import Entidades.Pelicula;
import Anexos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class iPeliculaDAO implements PeliculaDAO {
    @Override
    public void insertar_pelicula(Pelicula pelicula) {
        String query = "INSERT INTO pelicula (nombre, genero_principal, descripcion, precio) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = Conexion.conectar();

            PreparedStatement prepared_statement = connection.prepareStatement(query);
            prepared_statement.setString(1, pelicula.getNombre());
            prepared_statement.setString(2, pelicula.getGenero_principal());
            prepared_statement.setString(3, pelicula.getDescripcion());
            prepared_statement.setDouble(4, pelicula.getPrecio());
            prepared_statement.executeUpdate();

            System.out.println("\nDatos cargados correctamente.");

            prepared_statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("\nHubo un error en la carga de datos.");
        }
    }

    @Override
    public void eliminar_por_id(int id_peliculas) {
        String query = "DELETE FROM pelicula WHERE id_peliculas = ?";

        try {
            Connection connection = Conexion.conectar();

            PreparedStatement prepared_statement = connection.prepareStatement(query);
            prepared_statement.setInt(1, id_peliculas);
            int resultado = prepared_statement.executeUpdate();

            if (resultado != 0) {
                System.out.println("\nLa película fue eliminada correctamente.");
            }
            else {
                System.out.println("\nEl ID ingresado no corresponde a ninguna película.");
            }

            prepared_statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("\nHubo un error y no se pudo eliminar la película.");
        }
    }

    @Override
    public void eliminar_por_nombre(String nombre) {
        String query = "DELETE FROM pelicula WHERE nombre = ?";

        try {
            Connection connection = Conexion.conectar();

            PreparedStatement prepared_statement = connection.prepareStatement(query);
            prepared_statement.setString(1, nombre);
            int resultado = prepared_statement.executeUpdate();

            if (resultado != 0) {
                System.out.println("\nTodas las copias de '" + nombre + "' fueron eliminadas correctamente.");
            }
            else {
                System.out.println("\nEl nombre ingresado no corresponde a ninguna película.");
            }

            prepared_statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("\nHubo un error y no se pudieron eliminar las copias de '" + nombre + "'.");
        }
    }

    @Override
    public void editar_por_id(int id_peliculas) {
        String query = "UPDATE pelicula SET esta_alquilada = NOT esta_alquilada, veces_alquilada = CASE WHEN esta_alquilada = true THEN veces_alquilada + 1 ELSE veces_alquilada END WHERE id_peliculas = ?";

        try {
            Connection connection = Conexion.conectar();

            PreparedStatement prepared_statement = connection.prepareStatement(query);
            prepared_statement.setInt(1, id_peliculas);
            int resultado = prepared_statement.executeUpdate();

            if (resultado != 0) {
                System.out.println("\nDatos actualizados correctamente.");
            }
            else {
                System.out.println("\nEl ID ingresado no corresponde a ninguna película.");
            }

            prepared_statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("\nHubo un error en la edición de datos.");
        }
    }

    @Override
    public void editar_por_nombre(Pelicula pelicula) {
        String query = "UPDATE pelicula SET precio = ? WHERE nombre = ?";

        try {
            Connection connection = Conexion.conectar();

            PreparedStatement prepared_statement = connection.prepareStatement(query);
            prepared_statement.setDouble(1, pelicula.getPrecio());
            prepared_statement.setString(2, pelicula.getNombre());
            int resultado = prepared_statement.executeUpdate();

            if (resultado != 0) {
                System.out.println("\nEl precio de '" + pelicula.getNombre() + "' fue actualizado correctamente.");
            }
            else {
                System.out.println("\nEl nombre ingresado no corresponde a ninguna película existente.");
            }

            prepared_statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("\nHubo un error en la edición de datos.");
        }
    }

    @Override
    public void mostrar_por_id(int id_peliculas) {
        String query = "SELECT * FROM pelicula WHERE id_peliculas = ?";

        try {
            Connection connection = Conexion.conectar();

            PreparedStatement prepared_statement = connection.prepareStatement(query);
            prepared_statement.setInt(1, id_peliculas);
            ResultSet resultado = prepared_statement.executeQuery();

            if (resultado.next()) {
                System.out.println("\n-----------------------------------------------------------------------------------------------------------------");
                System.out.println("ID: " + resultado.getInt("id_peliculas"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Género principal: " + resultado.getString("genero_principal"));
                System.out.println("Descripción: " + resultado.getString("descripcion"));
                System.out.println("Precio: " + resultado.getDouble("precio"));
                System.out.println("Veces alquilada: " + resultado.getInt("veces_alquilada"));
                System.out.println("Esta alquilada: " + resultado.getBoolean("esta_alquilada"));
                System.out.println("-----------------------------------------------------------------------------------------------------------------");
            }
            else {
                System.out.println("\nEl ID ingresado no corresponde a ninguna película.");
            }

            prepared_statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("\nHubo un error en la consulta de datos.");
        }
    }

    @Override
    public void mostrar_por_nombre(String nombre) {
        String query = "SELECT * FROM pelicula WHERE nombre = ?";

        try {
            Connection connection = Conexion.conectar();

            PreparedStatement prepared_statement = connection.prepareStatement(query);
            prepared_statement.setString(1, nombre);
            ResultSet resultado = prepared_statement.executeQuery();

            if (resultado.next()) {
                System.out.println("\n-----------------------------------------------------------------------------------------------------------------");
                while (resultado.next()) {
                    System.out.println("ID: " + resultado.getInt("id_peliculas"));
                    System.out.println("Nombre: " + resultado.getString("nombre"));
                    System.out.println("Género principal: " + resultado.getString("genero_principal"));
                    System.out.println("Descripción: " + resultado.getString("descripcion"));
                    System.out.println("Precio: " + resultado.getDouble("precio"));
                    System.out.println("Veces alquilada: " + resultado.getInt("veces_alquilada"));
                    System.out.println("Esta alquilada: " + resultado.getBoolean("esta_alquilada"));
                    System.out.println("-----------------------------------------------------------------------------------------------------------------");
                }
            }
            else {
                System.out.println("\nEl nombre ingresado no corresponde a ninguna película.");
            }

            prepared_statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("\nHubo un error en la consulta de datos.");
        }
    }

    @Override
    public void mostrar_por_estado(boolean esta_alquilada) {
        String query = "SELECT * FROM pelicula WHERE esta_alquilada = ?";

        try {
            Connection connection = Conexion.conectar();

            PreparedStatement prepared_statement = connection.prepareStatement(query);
            prepared_statement.setBoolean(1, esta_alquilada);
            ResultSet resultado = prepared_statement.executeQuery();

            System.out.println("\n-----------------------------------------------------------------------------------------------------------------");
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id_peliculas"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Género principal: " + resultado.getString("genero_principal"));
                System.out.println("Descripción: " + resultado.getString("descripcion"));
                System.out.println("Precio: " + resultado.getDouble("precio"));
                System.out.println("Veces alquilada: " + resultado.getInt("veces_alquilada"));
                System.out.println("Esta alquilada: " + resultado.getBoolean("esta_alquilada"));
                System.out.println("-----------------------------------------------------------------------------------------------------------------");
            }

            prepared_statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("\nHubo un error en la consulta de datos.");
        }
    }

    @Override
    public void mostrar_todo() {
        String query = "SELECT * FROM pelicula";

        try {
            Connection connection = Conexion.conectar();

            PreparedStatement prepared_statement = connection.prepareStatement(query);
            ResultSet resultado = prepared_statement.executeQuery();

            System.out.println("\n-----------------------------------------------------------------------------------------------------------------");
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id_peliculas"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Género principal: " + resultado.getString("genero_principal"));
                System.out.println("Descripción: " + resultado.getString("descripcion"));
                System.out.println("Precio: " + resultado.getDouble("precio"));
                System.out.println("Veces alquilada: " + resultado.getInt("veces_alquilada"));
                System.out.println("Esta alquilada: " + resultado.getBoolean("esta_alquilada"));
                System.out.println("-----------------------------------------------------------------------------------------------------------------");
            }

            prepared_statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("\nHubo un error en la consulta de datos.");
        }
    }
}