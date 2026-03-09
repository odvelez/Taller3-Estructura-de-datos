import java.io.*;
import java.util.*;
public class CRUDArchivos{

    public static void OrdenarPrecio() throws IOException {
        
    }

    public static void AgregarCliente() throws IOException {
       
    }

    public static void calcularVentasProducto() throws IOException {
        Totalventa aux;
        double totalventa = 0;
        List<Producto> lista = leerProductos();
        List<Pedido> lista2 = leerPedidos();
        List<Totalventa> lista3 = new ArrayList<>();
        for (Producto p : lista) {
            for (Pedido p2 : lista2) {
                if(p.getId() == p2.getProducto_id()){
                    totalventa = totalventa + p.getPrecio() * p2.getCantidad();
                }
            }
            lista3.add(new Totalventa(p.getId(), p.getNombre(), totalventa));
        }
        for (int i = 0; i < lista3.size()- 1; i++) {
            for (int j = 0; j < lista3.size()-i-1; j++) {
                if(lista3.get(j).getTotal() < lista3.get(j+1).getTotal()){
                    lista3.set(j, lista3.get(j+1));
                    aux = lista3.get(j);
                    lista3.set(j+1, lista3.get(j));
                }
            }
        }

        FileWriter fw = new FileWriter("totalventas.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i = 0; i < lista3.size()-1; i++){
            bw.write(lista3.get(i).toString());
            bw.newLine();
        }
        bw.close();
    }

    public static void VerClientesCompras() throws IOException {
       
    }

    public static List<Producto> leerProductos() throws IOException {
    List<Producto> lista = new ArrayList<>();
    Scanner sc = new Scanner(new File("productos.csv"));

    while (sc.hasNextLine()) {
        String[] datos = sc.nextLine().split(",");
        lista.add(new Producto(Integer.parseInt(datos[0]), datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4])));
    }
    sc.close();
    return lista;

    
}
    public static List<Pedido> leerPedidos() throws IOException {
    List<Pedido> lista = new ArrayList<>();
    Scanner sc = new Scanner(new File("pedidos.csv"));

    while (sc.hasNextLine()) {
        String[] datos = sc.nextLine().split(",");
        lista.add(new Pedido(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), datos[4]));
    }
    sc.close();
    return lista;




    }

}