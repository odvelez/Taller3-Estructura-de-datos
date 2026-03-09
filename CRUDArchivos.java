import java.io.*;
import java.util.*;

public class CRUDArchivos {

    public static void OrdenarPrecio() throws IOException {

    }

    public static void AgregarCliente(Cliente cliente) throws IOException {
        FileWriter fw = new FileWriter("clientes.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(cliente.toString());
        bw.newLine();
        bw.close();
    }

    public static void calcularVentasProducto() throws IOException {
    
    }

    public static void VerClientesCompras() throws IOException {
        List<Cliente> clientes = leerClientes();
        List<Integer> idsCompras = clientesConCompras();
        List<Cliente> clientesFinal = filtrarClientesCompras(clientes, idsCompras);
        ordenarClientesNombre(clientesFinal);
        mostrarClientes(clientesFinal);
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

    public static List<Cliente> leerClientes() throws IOException {

    List<Cliente> clientes = new ArrayList<>();

    Scanner sc = new Scanner(new File("clientes.csv"));

    while (sc.hasNextLine()) {

        String[] datos = sc.nextLine().split(",");

        clientes.add(new Cliente(
                Integer.parseInt(datos[0]),
                datos[1],
                datos[2]
        ));
    }

    sc.close();

    return clientes;
}

public static List<Integer> clientesConCompras() throws IOException {

    List<Integer> lista = new ArrayList<>();

    Scanner sc = new Scanner(new File("pedidos.csv"));

    while (sc.hasNextLine()) {

        String[] datos = sc.nextLine().split(",");

        int clienteId = Integer.parseInt(datos[1]);

        if (!lista.contains(clienteId)) {
            lista.add(clienteId);
        }
    }

    sc.close();

    return lista;
}

public static List<Cliente> filtrarClientesCompras(List<Cliente> clientes, List<Integer> ids) {

    List<Cliente> resultado = new ArrayList<>();

    for (Cliente c : clientes) {

        if (ids.contains(c.getId())) {
            resultado.add(c);
        }
    }

    return resultado;
}

public static void ordenarClientesNombre(List<Cliente> lista) {

    for (int i = 0; i < lista.size() - 1; i++) {

        for (int j = 0; j < lista.size() - 1 - i; j++) {

            if (lista.get(j).getNombre()
                    .compareToIgnoreCase(lista.get(j + 1).getNombre()) > 0) {

                Cliente temp = lista.get(j);
                lista.set(j, lista.get(j + 1));
                lista.set(j + 1, temp);
            }
        }
    }
}

public static void mostrarClientes(List<Cliente> lista) {

    System.out.println("\nClientes que han realizado compras:");

    for (Cliente c : lista) {

        System.out.println(c.getNombre() + " - " + c.getEmail());
    }
}

}