import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n------ SISTEMA E-COMMERCE ------");
            System.out.println("1. Ver productos ordenados por precio");
            System.out.println("2. Agregar nuevo cliente");
            System.out.println("3. Total de ventas producido por el producto");
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

                }

                else if (opcion == 2) {

                    System.out.println("Ingrese el Id: ");
                    int id = sc.nextInt();
                    System.out.println("Ingrese el nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el email: ");
                    String email = sc.nextLine();
                    
                    Cliente cliente = new Cliente (id,nombre,email);

                    CRUDArchivos.AgregarCliente(cliente);

                }

                else if (opcion == 3) {

                }

                else if (opcion == 4) {
                    CRUDArchivos.VerClientesCompras();
                }

                else {
                    if (opcion > 5) {
                        System.out.println("Opción inválida. Por favor elija un número del 1 al 5.");
                    }

                }

            } catch (Exception e) {

                System.out.println("Error al manejar archivos: " + e.getMessage());

            }

        }

        sc.close();
    }
}