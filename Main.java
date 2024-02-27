public class Main {
    public static void main(String[] args){
        //Creación de objetos para probar los métodos de la clase Producto
        Producto producto1 = new Producto("Xbox Series S", 7899.50,5);
        Producto producto2 = new Producto("PlayStation 5",11999.89);
        Producto producto3 = new Producto("Xbox Series X",12299.75,4);
        Producto producto4 = new Producto("Nintendo DS",7899.50);
        //Impresión de los datos
        System.out.println(producto1.getNombre());
        System.out.println(producto1.getPrecio());
        System.out.println(producto1.getStock());
        System.out.println();//Salto de línea
        System.out.println(producto2.getNombre());
        System.out.println(producto2.getPrecio());
        System.out.println(producto2.getStock());
        System.out.println();//Salto de línea
        System.out.println(producto3.getNombre());
        System.out.println(producto3.getPrecio());
        System.out.println(producto3.getStock());
        System.out.println();//Salto de línea
        System.out.println(producto4.getNombre());
        System.out.println(producto4.getPrecio());
        System.out.println(producto4.getStock());
        System.out.println();//Salto de línea
        System.out.println("***************");
        System.out.println();
        //Uso de los métodos set para cambiar el stock de los productos
        producto1.aumentarStock(4);
        producto2.setStock(4);
        producto3.reducirStock(2);
        producto3.setPrecio(10389.75);
        producto4.setNombre("Nintendo Switch OLED");
        producto4.setStock(6);
        //Impresión de los nuevos datos
        System.out.println("Datos modificados:\n");
        System.out.println(producto1.getNombre());
        System.out.println(producto1.getStock());
        System.out.println();//Salto de línea
        System.out.println(producto2.getNombre());
        System.out.println(producto2.getStock());
        System.out.println();//Salto de Línea
        System.out.println(producto3.getNombre());
        System.out.println(producto3.getPrecio());
        System.out.println();//Salto de línea
        System.out.println(producto4.getNombre());
        System.out.println(producto4.getStock());
    }
}
