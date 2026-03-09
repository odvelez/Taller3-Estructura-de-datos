import java.io.*;
import java.util.*;

public class CRUDArchivos {

    public static void OrdenarPrecio() throws IOException {
        List<Producto> productos = leerProductos();

        int n = productos.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (productos.get(j).getPrecio() > productos.get(j + 1).getPrecio()) {

                    Producto temp = productos.get(j);

                    productos.set(j, productos.get(j + 1));

                    productos.set(j + 1, temp);

                }
            }
        }

        System.out.println("Productos ordenados por precio:");

        for (Producto p : productos) {

            System.out.println(
                    p.getNombre() + " - $" + p.getPrecio() + " - Stock: " + p.getStock());

        }
    }

    public static void AgregarCliente() throws IOException {

    }

    public static void calcularVentasProducto() throws IOException {
    }

    public static void VerClientesCompras() throws IOException {

    }

    public static List<Producto> leerProductos() throws IOException {
        List<Producto> lista = new ArrayList<>();
        Scanner sc = new Scanner(new File("productos.csv"));

        while (sc.hasNextLine()) {
            String[] datos = sc.nextLine().split(",");
            lista.add(new Producto(Integer.parseInt(datos[0]), datos[1], datos[2], Double.parseDouble(datos[3]),
                    Integer.parseInt(datos[4])));
        }
        sc.close();
        return lista;

    }

    public static List<Pedido> leerPedidos() throws IOException {
    List<Pedido> lista = new ArrayList<>();
    Scanner sc = new Scanner(new File("pedidos.csv"));

    while (sc.hasNextLine()) {
        String[] datos = sc.nextLine().split(",");
        lista.add(new Pedido(Integer.parseInt());
    }
    sc.close();
    return lista;

    }

}