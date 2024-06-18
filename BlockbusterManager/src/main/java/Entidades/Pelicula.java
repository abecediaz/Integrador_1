package Entidades;

public class Pelicula {
    /*ATRIBUTOS*/
    protected int id_peliculas;
    protected String nombre;
    protected String genero_principal;
    protected String descripcion;
    protected double precio = 12.00;
    protected int veces_alquilada = 0;
    protected boolean esta_alquilada = false;

    /*MÉTODOS*/

    /*CONSTRUCTORES*/
    public Pelicula() {
    }

    public Pelicula(String nombre, String genero_principal, String descripcion, double precio, int veces_alquilada, boolean esta_alquilada) {
        this.nombre = nombre;
        this.genero_principal = genero_principal;
        this.descripcion = descripcion;
        this.precio = precio;
        this.veces_alquilada = veces_alquilada;
        this.esta_alquilada = esta_alquilada;
    }

    public Pelicula(int id_peliculas, String nombre, String genero_principal, String descripcion, double precio, int veces_alquilada, boolean esta_alquilada) {
        this.id_peliculas = id_peliculas;
        this.nombre = nombre;
        this.genero_principal = genero_principal;
        this.descripcion = descripcion;
        this.precio = precio;
        this.veces_alquilada = veces_alquilada;
        this.esta_alquilada = esta_alquilada;
    }

    /*TO-STRING*/
    @Override
    public String toString() {
        return "Pelicula{" +
                "id_peliculas=" + id_peliculas +
                ", nombre='" + nombre + '\'' +
                ", genero_principal='" + genero_principal + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", veces_alquilada=" + veces_alquilada +
                ", esta_alquilada=" + esta_alquilada +
                '}';
    }

    /*SETTERS*/
    public void setId_peliculas(int id_peliculas) {
        this.id_peliculas = id_peliculas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero_principal(String genero_principal) {
        this.genero_principal = genero_principal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setVeces_alquilada(int veces_alquilada) {
        this.veces_alquilada = veces_alquilada;
    }

    public void setEsta_alquilada(boolean esta_alquilada) {
        this.esta_alquilada = esta_alquilada;
    }

    /*GETTERS*/
    public int getId_peliculas() {
        return id_peliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero_principal() {
        return genero_principal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getVeces_alquilada() {
        return veces_alquilada;
    }

    public boolean isEsta_alquilada() {
        return esta_alquilada;
    }
}
