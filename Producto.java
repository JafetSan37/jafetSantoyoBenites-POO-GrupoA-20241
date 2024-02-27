public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    //Constructores
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public Producto(String nombre, double precio){
        stock=0;
        this.nombre = nombre;
        this.precio = precio;
    }
    //Getters y Setters para todos los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre!=null){
            this.nombre = nombre;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio>0){
            this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock>0){
            this.stock = stock;
        }
    }
    //Métodos adicionales
    public void aumentarStock(int cantidad){
        if (cantidad>0){
            stock += cantidad;
        }
    }
    public void reducirStock(int cantidad){
        if (cantidad>0 & cantidad <=stock){
            stock -= cantidad;
        }
    }
}
