public class Persona {
    public String nombre;
    public int edad;
    public String genero;
    //Método Constructor
    public Persona (String nom, int age, String genre){
        nombre = nom;
        edad = age;
        genero = genre;
    }
    //Método para imprimir los atributos de los objetos creados.
    public String imprimirDato(){
        String dato = String.format("Nombre: %s\nEdad: %d\nGénero: %s", nombre, edad, genero);
        return dato;
    }
}
