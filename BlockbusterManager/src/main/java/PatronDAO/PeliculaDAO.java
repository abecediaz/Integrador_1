package PatronDAO;
import Entidades.Pelicula;

public interface PeliculaDAO {
//  Insertar: película nueva
    void insertar_pelicula(Pelicula pelicula);

//  Eliminar: por id (UNA COPIA EN PARTICULAR. POR ROTURA, EXTRAVÍO)
    void eliminar_por_id(int id_peliculas);

//  Eliminar: por nombre (TODAS LAS COPIAS. DISCONTINUAR SU REPLICACIÓN)
    void eliminar_por_nombre(String nombre);

//  Editar: por id (CAMBIAR EL ESTADO DEL ALQUILER Y CANTIDAD DE VECES ALQUILADO)
    void editar_por_id(int id_peliculas);

//  Editar: por nombre (CAMBIAR EL PRECIO)
    void editar_por_nombre(String nombre);

//  Mostrar: por id (UNA COPIA EN PARTICULAR)
    void mostrar_por_id(int id_peliculas);

//  Mostrar: por nombre (UNA PELICULA EN GENERAL)
    void mostrar_por_nombre(String nombre);

//  Mostrar: por estado del alquiler (ALQUILADAS Y NO ALQUILADAS)
    void mostrar_por_estado(boolean esta_alquilada);

//  Mostrar: todo
    void mostrar_todo();

}