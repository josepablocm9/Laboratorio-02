import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Caso caso;

    public static void main(String[] args) {

        System.out.println("AGENCIA DE DETECTIVES");
        System.out.println("CASO MISTERIOSO");


        crearCaso();

        boolean continuar = true;

        while (continuar) {

            mostrarMenu();

            int opcion = leerEntero("Seleccione una opción: ");

            try {

                switch (opcion) {

                    case 1:
                        crearCaso();
                        break;

                    case 2:
                        registrarUbicacion();
                        break;

                    case 3:
                        caso.consultarUbicaciones();
                        break;

                    case 4:
                        consultarUbicacion();
                        break;

                    case 5:
                        modificarUbicacion();
                        break;

                    case 6:
                        descartarUbicacion();
                        break;

                    case 7:
                        registrarPista();
                        break;

                    case 8:
                        caso.consultarPistas();
                        break;

                    case 9:
                        buscarPista();
                        break;

                    case 10:
                        modificarPista();
                        break;

                    case 11:
                        eliminarPista();
                        break;

                    case 12:
                        caso.generarReporte();
                        break;

                    case 13:
                        continuar = false;
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Opción inválida.");

                }

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (IndexOutOfBoundsException e) {

                System.out.println("Error: " + e.getMessage());

            } finally {

                if (continuar) {
                    System.out.println("\nFin de la operación.");
                }
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {

        System.out.println("MENU");

        System.out.println("1. Nuevo caso");
        System.out.println("2. Registrar ubicación");
        System.out.println("3. Consultar ubicaciones");
        System.out.println("4. Consultar una ubicación");
        System.out.println("5. Modificar ubicación");
        System.out.println("6. Descartar ubicación");
        System.out.println("7. Registrar pista");
        System.out.println("8. Consultar pistas");
        System.out.println("9. Buscar pista");
        System.out.println("10. Modificar pista");
        System.out.println("11. Eliminar pista");
        System.out.println("12. Mostrar reporte de investigación");
        System.out.println("13. Salir");
    }


    private static void crearCaso() {

        System.out.println("NUEVO CASO");

        String nombre = leerTexto("Nombre del caso: ");
        String codigo = leerTexto("Código de identificación: ");
        String detective = leerTexto("Detective responsable: ");

        try {

            caso = new Caso(nombre, codigo, detective);

            System.out.println("Caso creado correctamente.");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }


    private static void registrarUbicacion() {

        System.out.println("REGISTRAR UBICACIÓN");

        int posicion = leerEntero(
                "Posición del arreglo (0-4): "
        );

        String codigo = leerTexto("Código: ");
        String nombre = leerTexto("Nombre: ");
        String direccion = leerTexto("Dirección o descripción: ");
        int riesgo = leerEntero("Nivel de riesgo (1-10): ");
        String estado = leerTexto("Estado: ");

        Ubicacion ubicacion = new Ubicacion(
                codigo,
                nombre,
                direccion,
                riesgo,
                estado
        );

        caso.registrarUbicacion(posicion, ubicacion);

        System.out.println("Ubicación registrada correctamente.");
    }

    private static void consultarUbicacion() {

        System.out.println("CONSULTAR UBICACIÓN");

        int posicion = leerEntero(
                "Posición del arreglo (0-4): "
        );

        caso.consultarUbicacion(posicion);
    }

    private static void modificarUbicacion() {

        System.out.println("MODIFICAR UBICACIÓN");

        int posicion = leerEntero(
                "Posición de la ubicación: "
        );

        int nuevoRiesgo = leerEntero(
                "Nuevo nivel de riesgo (1-10): "
        );

        String nuevoEstado = leerTexto(
                "Nuevo estado: "
        );

        caso.modificarUbicacion(
                posicion,
                nuevoRiesgo,
                nuevoEstado
        );

        System.out.println("Ubicación modificada correctamente.");
    }

    private static void descartarUbicacion() {

        System.out.println("DESCARTAR UBICACIÓN");

        int posicion = leerEntero(
                "Posición de la ubicación: "
        );

        caso.descartarUbicacion(posicion);

        System.out.println(
                "Ubicación descartada. La posición vuelve a estar disponible."
        );
    }


    private static void registrarPista() {

        System.out.println("REGISTRAR PISTA");

        String codigo = leerTexto("Código: ");
        String descripcion = leerTexto("Descripción: ");
        String tipo = leerTexto("Tipo de evidencia: ");

        int importancia = leerEntero(
                "Nivel de importancia (1-10): "
        );

        double confiabilidad = leerDouble(
                "Nivel de confiabilidad (0-100): "
        );

        Pista pista = new Pista(
                codigo,
                descripcion,
                tipo,
                importancia,
                confiabilidad
        );

        caso.registrarPista(pista);

        System.out.println("Pista registrada correctamente.");
    }

    private static void buscarPista() {

        System.out.println("BUSCAR PISTA");

        String codigo = leerTexto(
                "Código de la pista: "
        );

        caso.mostrarPista(codigo);
    }

    private static void modificarPista() {

        System.out.println("MODIFICAR PISTA");

        String codigo = leerTexto(
                "Código de la pista: "
        );

        String descripcion = leerTexto(
                "Nueva descripción: "
        );

        String tipo = leerTexto(
                "Nuevo tipo de evidencia: "
        );

        int importancia = leerEntero(
                "Nuevo nivel de importancia (1-10): "
        );

        double confiabilidad = leerDouble(
                "Nuevo nivel de confiabilidad (0-100): "
        );

        caso.modificarPista(
                codigo,
                descripcion,
                tipo,
                importancia,
                confiabilidad
        );

        System.out.println("Pista modificada correctamente.");
    }

    private static void eliminarPista() {

        System.out.println("ELIMINAR PISTA");

        String codigo = leerTexto(
                "Código de la pista: "
        );

        caso.eliminarPista(codigo);
    }


    private static int leerEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                int valor = scanner.nextInt();
                scanner.nextLine();

                return valor;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: debe ingresar un número entero."
                );

                scanner.nextLine();
            }
        }
    }

    private static double leerDouble(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                double valor = scanner.nextDouble();
                scanner.nextLine();

                return valor;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: debe ingresar un número."
                );

                scanner.nextLine();
            }
        }
    }

    private static String leerTexto(String mensaje) {

        System.out.print(mensaje);

        String texto = scanner.nextLine().trim();

        while (texto.isEmpty()) {

            System.out.println(
                    "El valor no puede estar vacío."
            );

            System.out.print(mensaje);

            texto = scanner.nextLine().trim();
        }

        return texto;
    }
}