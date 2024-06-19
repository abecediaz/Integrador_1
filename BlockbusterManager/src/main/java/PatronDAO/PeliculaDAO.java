package PatronDAO;
import Entidades.Pelicula;

public interface PeliculaDAO {
    void insertar_pelicula(Pelicula pelicula);

    void eliminar_por_id(int id_peliculas);

    void eliminar_por_nombre(String nombre);

    void editar_por_id(int id_peliculas, int veces_alquilada, boolean esta_alquilada);

    void editar_por_nombre(String nombre, double precio);

    void mostrar_por_id(int id_peliculas);

    void mostrar_por_nombre(String nombre);

//  Mostrar: por estado del alquiler (ALQUILADAS Y NO ALQUILADAS)
    void mostrar_por_estado(boolean esta_alquilada);

//  Mostrar: todo
    void mostrar_todo();
}