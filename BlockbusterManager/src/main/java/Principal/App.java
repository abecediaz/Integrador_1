package Principal;
import Anexos.*;
import Entidades.*;
import PatronDAO.*;
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
                    imprimir_menu_agregar();
                    opcion = scanner.nextInt();
                    while (menu_sub) {
                        switch (opcion) {
                            case 1:
                                ingresar_datos(pelicula);
                                pelicula_DAO.insertar_pelicula(pelicula);
                                break;
                            case 2:
                                menu_sub = false;
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("El término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
                        }
                    }
                    break;
                case 2:
                    imprimir_menu_eliminar();
                    opcion = scanner.nextInt();
                    while (menu_sub) {
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese el número ID de la película: ");
                                pelicula_DAO.eliminar_por_id(scanner.nextInt());
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre de la película: ");
                                pelicula_DAO.eliminar_por_nombre(scanner.nextLine());
                                break;
                            case 3:
                                menu_sub = false;
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("El término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
                        }
                    }
                    break;
                case 3:
                    imprimir_menu_actualizar();
                    opcion = scanner.nextInt();
                    while (menu_sub) {
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese el número ID de la película: ");
                                pelicula_DAO.editar_por_id(scanner.nextInt(), pelicula);
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre de la película: ");
                                System.out.println("Ingrese el precio nuevo: $");
                                pelicula_DAO.editar_por_nombre(scanner.nextLine(), scanner.nextDouble());
                                break;
                            case 3:
                                menu_sub = false;
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("El término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
                        }
                    }
                    break;
                case 4:
                    imprimir_menu_consultar();
                    opcion = scanner.nextInt();
                    while (menu_sub) {
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese el número ID de la película: ");
                                pelicula_DAO.mostrar_por_id(scanner.nextInt());
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre de la película: ");
                                pelicula_DAO.mostrar_por_nombre(scanner.nextLine());
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
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("El término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
                        }
                    }
                    break;
                case 5:
                    menu_principal = false;
                    System.out.println("Cerrando programa...");
                    break;
                default:
                    System.out.println("El término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente.");
            }
        } while (menu_principal);

        scanner.close();
    }

    public static void imprimir_menu_principal() {
        System.out.println("\t\tMENÚ PRINCIPAL");
        System.out.println("1) Agregar una película.");
        System.out.println("2) Eliminar una película.");
        System.out.println("3) Actualizar datos.");
        System.out.println("4) Consultar datos.");
        System.out.println("5) Salir del programa.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void imprimir_menu_agregar() {
        System.out.println("\t\tAGREGAR UNA PELÍCULA");
        System.out.println("1) Agregar una película.");
        System.out.println("2) Volver al menú principal.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void imprimir_menu_eliminar() {
        System.out.println("\t\tELIMINAR UNA PELÍCULA");
        System.out.println("1) Eliminar una copia.");
        System.out.println("2) Eliminar una película.");
        System.out.println("3) Volver al menú principal.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void imprimir_menu_actualizar() {
        System.out.println("\t\tACTUALIZAR DATOS");
        System.out.println("1) Actualizar estado de alquiler.");
        System.out.println("2) Actualizar precio de películas.");
        System.out.println("3) Volver al menú principal.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void imprimir_menu_consultar() {
        System.out.println("\t\tCONSULTAR DATOS");
        System.out.println("1) Consultar datos de una copia.");
        System.out.println("2) Consultar datos de una película.");
        System.out.println("3) Consultar películas alquiladas.");
        System.out.println("4) Consultar películas no alquiladas.");
        System.out.println("5) Consultar todas las películas.");
        System.out.println("6) Volver al menú principal.");
        System.out.print("Ingrese el número correspondiente a la opción que quiera realizar: ");
    }

    public static void ingresar_datos(Pelicula pelicula) {
        ingresar_nombre(pelicula);
        ingresar_genero(pelicula);
        ingresar_descripcion(pelicula);
        ingresar_precio(pelicula);
    }

    public static void ingresar_nombre(Pelicula pelicula) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la película: ");
        String nombre = scanner.nextLine();
        pelicula.setNombre(nombre);
    }

    public static void ingresar_genero(Pelicula pelicula) {
        Scanner scanner = new Scanner(System.in);

        for (Genero genero : Genero.values()) {
            System.out.println(genero.ordinal() + 1 + ") " + genero);
        }

        System.out.print("Ingrese el número correspondiente al género de la película: ");
        int opcion = scanner.nextInt();

        while (opcion < 1 || opcion > Genero.values().length){
            System.out.print("El término que ingresó (" + opcion + ") no es válido. Por favor, inténtelo nuevamente: ");
            opcion = scanner.nextInt();
        }

        pelicula.setGenero_principal(String.valueOf((Genero.values()[opcion - 1])));
    }

    public static void ingresar_descripcion(Pelicula pelicula) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la sinópsis de la película: ");
        String sinopsis = scanner.nextLine();
        pelicula.setDescripcion(sinopsis);
    }

    public static void ingresar_precio(Pelicula pelicula) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el precio de la película: $");
        double precio = scanner.nextDouble();
        pelicula.setPrecio(precio);
    }
}