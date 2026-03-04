import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n------ SISTEMA E-COMMERCE ------");
            System.out.println("1. Ver productos ordenados por precio");
            System.out.println("2. Agregar nuevo cliente");
            System.out.println("3. Calcular total de ventas por producto");
            System.out.println("4. Ver clientes que han realizado compras");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
                opcion = 0;
            }

            try {

                if (opcion == 1) {

                    CrudArchivos.ordenarProductosPorPrecio();

                }

                else if (opcion == 2) {

                    System.out.print("Ingrese nombre del cliente: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese email del cliente: ");
                    String email = sc.nextLine();

                    CrudArchivos.agregarCliente(nombre, email);

                }

                else if (opcion == 3) {

                    CrudArchivos.calcularTotalVentas();

                }

                else if (opcion == 4) {

                    CrudArchivos.verClientesConCompras();

                }

                else if (opcion == 5) {

                    System.out.println("Programa finalizado.");

                }

                else {

                    System.out.println("Opcion no valida.");

                }

            } catch (IOException e) {

                System.out.println("Error al manejar archivos: " + e.getMessage());

            }

        }

        sc.close();
    }
}