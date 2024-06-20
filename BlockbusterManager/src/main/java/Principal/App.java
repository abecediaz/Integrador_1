package Principal;
import Anexos.*;
import Entidades.*;
import PatronDAO.*;
import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pelicula pelicula = new Pelicula();
        PeliculaDAO pelicula_DAO = new iPeliculaDAO();
        boolean menu_principal = true;
        boolean menu_sub = true;

        do {
            imprimir_menu_principal();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    do {
                        imprimir_menu_agregar();
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1:
                                ingresar_datos(pelicula);
                                pelicula_DAO.insertar_pelicula(pelicula);
                                break;
                            case 2:
                                menu_sub = false;
                                break;
                            default:
                                System.out.println("\nEl término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
                        }
                    } while (menu_sub);
                    break;
                case 2:
                    do {
                        imprimir_menu_eliminar();
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1:
                                System.out.print("\nIngrese el número ID de la película: ");
                                int id_peliculas = scanner.nextInt();
                                pelicula_DAO.eliminar_por_id(id_peliculas);
                                break;
                            case 2:
                                System.out.print("\nIngrese el nombre de la película: ");
                                String nombre = scanner.nextLine();
                                pelicula_DAO.eliminar_por_nombre(nombre);
                                break;
                            case 3:
                                menu_sub = false;
                                break;
                            default:
                                System.out.println("\nEl término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
                        }
                    } while (menu_sub);
                    break;
                case 3:
                    do {
                        imprimir_menu_actualizar();
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1:
                                System.out.print("\nIngrese el número ID de la película: ");
                                int id_peliculas = scanner.nextInt();
                                pelicula_DAO.editar_por_id(id_peliculas);
                                break;
                            case 2:
                                System.out.print("\nIngrese el nombre de la película: ");
                                String nombre = scanner.nextLine();
                                pelicula.setNombre(nombre);

                                System.out.print("Ingrese el precio nuevo de la película: $");
                                double precio = scanner.nextDouble();
                                pelicula.setPrecio(precio);

                                pelicula_DAO.editar_por_nombre(pelicula);
                                break;
                            case 3:
                                menu_sub = false;
                                break;
                            default:
                                System.out.println("\nEl término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
                        }
                    } while (menu_sub);
                    break;
                case 4:
                    do {
                        imprimir_menu_consultar();
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1:
                                System.out.print("\nIngrese el número ID de la película: ");
                                int id_peliculas = scanner.nextInt();
                                pelicula_DAO.mostrar_por_id(id_peliculas);
                                break;
                            case 2:
                                System.out.print("\nIngrese el nombre de la película: ");
                                String nombre = scanner.nextLine();
                                pelicula_DAO.mostrar_por_nombre(nombre);
                                break;
                            case 3:
                                pelicula_DAO.mostrar_por_estado(true);
                                break;
                            case 4:
                                pelicula_DAO.mostrar_por_estado(false);
                                break;
                            case 5:
                                pelicula_DAO.mostrar_todo();
                                break;
                            case 6:
                                menu_sub = false;
                                break;
                            default:
                                System.out.println("\nEl término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
                        }
                    } while (menu_sub);
                    break;
                case 5:
                    menu_principal = false;
                    System.out.println("\nCerrando programa...");
                    break;
                default:
                    System.out.println("\nEl término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
            }
        } while (menu_principal);

        scanner.close();
    }

    public static void imprimir_menu_principal() {
        System.out.println("\n\t• MENÚ PRINCIPAL •");
        System.out.println("1) Agregar una película.");
        System.out.println("2) Eliminar una película.");
        System.out.println("3) Actualizar datos.");
        System.out.println("4) Consultar datos.");
        System.out.println("5) Salir del programa.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void imprimir_menu_agregar() {
        System.out.println("\n\t• AGREGAR UNA PELÍCULA •");
        System.out.println("1) Agregar una película.");
        System.out.println("2) Volver al menú principal.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void imprimir_menu_eliminar() {
        System.out.println("\n\t• ELIMINAR UNA PELÍCULA •");
        System.out.println("1) Eliminar una copia.");
        System.out.println("2) Eliminar una película.");
        System.out.println("3) Volver al menú principal.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void imprimir_menu_actualizar() {
        System.out.println("\n\t• ACTUALIZAR DATOS •");
        System.out.println("1) Actualizar estado de alquiler.");
        System.out.println("2) Actualizar precio de películas.");
        System.out.println("3) Volver al menú principal.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void imprimir_menu_consultar() {
        System.out.println("\n\t• CONSULTAR DATOS •");
        System.out.println("1) Consultar datos de una copia.");
        System.out.println("2) Consultar datos de una película.");
        System.out.println("3) Consultar películas alquiladas.");
        System.out.println("4) Consultar películas no alquiladas.");
        System.out.println("5) Consultar todas las películas.");
        System.out.println("6) Volver al menú principal.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void ingresar_datos(Pelicula pelicula) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese el nombre de la película: ");
        String nombre = scanner.nextLine();
        pelicula.setNombre(nombre);

        for (Genero genero : Genero.values()) {
            System.out.println(genero.ordinal() + 1 + ") " + genero);
        }

        System.out.print("\nIngrese el número correspondiente al género de la película: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        while (opcion < 1 || opcion > Genero.values().length){
            System.out.print("\nEl término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        pelicula.setGenero_principal(String.valueOf((Genero.values()[opcion - 1])));

        System.out.print("\nIngrese la sinópsis de la película: ");
        String sinopsis = scanner.nextLine();
        pelicula.setDescripcion(sinopsis);

        System.out.print("\nIngrese el precio de la película: $");
        double precio = scanner.nextDouble();
        pelicula.setPrecio(precio);
    }
}