public class Producto{
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    public Pedido(int id, int cliente_id, int producto_id, int cantidad, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId(){
        return id;
    }

    public int getNombre(){
        return nombre;
    }

    public int getCategoria(){
        return categoria;
    }

    public int getPrecio(){
        return precio;
    }

    public String getStock(){
        return stock;
    }

    public String toString() {
        return id + "," + nombre + "," + categoria + "," + precio + "," + stock;
    }
}