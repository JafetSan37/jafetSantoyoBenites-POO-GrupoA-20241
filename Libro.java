public class Libro {
    String titulo = "El Psicoanalista";
    String autor = "John Katzenbach";
    int anio = 2002;
    //Método para imprimir datos del libro
    public String imprimirFicha(){
        String ficha = String.format("Libro: %s\nAutor: %s\nAño: %d", titulo, autor, anio);
        return ficha;
    }
}
