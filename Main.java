public class Main {
    public static void main(String[] args){
        //Ejercicio 1 - Clase Persona
        System.out.println("Ejercicio 1:\n");
        //Creación de objetos o instancias
        Persona person1 = new Persona ("Juan", 18, "Masculino");
        Persona person2 = new Persona ("Alicia", 21, "Femenino");
        Persona person3 = new Persona ("Sonia", 24, "Femenino");
        Persona person4 = new Persona ("Alejandro", 20, "Masculino");
        //Impresión de los datos
        String informacion = person1.imprimirDato();
        System.out.println(informacion);
        System.out.println("***************");
        informacion = person2.imprimirDato();
        System.out.println(informacion);
        System.out.println("***************");
        informacion = person3.imprimirDato();
        System.out.println(informacion);
        System.out.println("***************");
        informacion = person4.imprimirDato();
        System.out.println(informacion);
        System.out.println("***************");
        System.out.println();

        //Ejercicio 2 - Clase Libro
        System.out.println("Ejercicio 2:\n");
        //Primera instancia
        Libro libro1 = new Libro();
        String fichaBiblio = libro1.imprimirFicha();
        System.out.println(fichaBiblio);
        System.out.println("**************");
        //Creación de más instancias
        Libro libro2 = new Libro();
        libro2.titulo = "Cazadores de Sombras";
        libro2.autor = "Cassandra Clare";
        libro2.anio = 2007;
        fichaBiblio = libro2.imprimirFicha();
        System.out.println(fichaBiblio);
        System.out.println("**************");
        Libro libro3 = new Libro();
        libro3.titulo = "Caballo de Troya";
        libro3.autor = "J.J. Benítez";
        libro3.anio = 1984;
        fichaBiblio = libro3.imprimirFicha();
        System.out.println(fichaBiblio);
        System.out.println("**************");
        Libro libro4 = new Libro();
        libro4.titulo = "Los Cuatro Acuerdos";
        libro4.autor = "Miguel Ruiz";
        libro4.anio = 1997;
        fichaBiblio = libro4.imprimirFicha();
        System.out.println(fichaBiblio);
        System.out.println("**************");
        System.out.println();

        //Ejercicio 3 - Clase Rectangulo
        System.out.println("Ejercicio 3:\n");
        double area, perimetro;
        //Instancias
        Rectangulo rectangulo1 = new Rectangulo(14.5,6.89);
        Rectangulo rectangulo2 = new Rectangulo(20.74,12.73);
        Rectangulo rectangulo3 = new Rectangulo(16.83,8.64);
        Rectangulo rectangulo4 = new Rectangulo(24.78,16.24);
        //Calculo Area y Perimetro
        perimetro = rectangulo1.calcularPerimetro();
        area = rectangulo1.calcularArea();
        System.out.printf("Rectangulo 1:\nPerímetro: %.2f\nÁrea: %.2f\n",perimetro,area);
        System.out.println("***************");
        perimetro = rectangulo2.calcularPerimetro();
        area = rectangulo2.calcularArea();
        System.out.printf("Rectangulo 2:\nPerímetro: %.2f\nÁrea: %.2f\n",perimetro,area);
        System.out.println("***************");
        perimetro = rectangulo3.calcularPerimetro();
        area = rectangulo3.calcularArea();
        System.out.printf("Rectangulo 3:\nPerímetro: %.2f\nÁrea: %.2f\n",perimetro,area);
        System.out.println("***************");
        perimetro = rectangulo4.calcularPerimetro();
        area = rectangulo4.calcularArea();
        System.out.printf("Rectangulo 4:\nPerímetro: %.2f\nÁrea: %.2f\n",perimetro,area);
        System.out.println("***************");
    }
}
