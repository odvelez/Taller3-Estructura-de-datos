public class Totalventa{

    private int producto_id;
    private String nombre_producto;
    private int total;

    public Totalventa(int producto_id, String nombre_producto, int total) {
        this.producto_id = producto_id;
        this.nombre_producto = nombre_producto;
        this.total = total;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return producto_id + "," + nombre_producto + "," + total;
    }
}