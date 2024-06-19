package Principal;
import Anexos.*;
import Entidades.*;
import PatronDAO.*;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
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
                                
                                break;
                            case 2:

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
                case 2:
                    imprimir_menu_eliminar();
                    opcion = scanner.nextInt();
                    while (menu_sub) {
                        switch (opcion) {
                            case 1:

                                break;
                            case 2:

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

                                break;
                            case 2:

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

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:
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
        System.out.println("5) Salir del programa.\n");
    }

    public static void imprimir_menu_agregar() {
        System.out.println("\t\tAGREGAR UNA PELÍCULA");
        System.out.println("1) Agregar una copia.");
        System.out.println("2) Agregar una película.");
        System.out.println("3) Volver al menú principal.\n");
    }

    public static void imprimir_menu_eliminar() {
        System.out.println("\t\tELIMINAR UNA PELÍCULA");
        System.out.println("1) Eliminar una copia.");
        System.out.println("2) Eliminar una película.");
        System.out.println("3) Volver al menú principal.\n");
    }

    public static void imprimir_menu_actualizar() {
        System.out.println("\t\tACTUALIZAR DATOS");
        System.out.println("1) Actualizar estado de alquiler.");
        System.out.println("2) Actualizar precio de películas.");
        System.out.println("3) Volver al menú principal.\n");
    }

    public static void imprimir_menu_consultar() {
        System.out.println("\t\tCONSULTAR DATOS");
        System.out.println("1) Consultar datos de una copia.");
        System.out.println("2) Consultar datos de una película.");
        System.out.println("3) Consultar películas alquiladas.");
        System.out.println("4) Consultar películas no alquiladas.");
        System.out.println("5) Volver al menú principal.\n");
    }
}