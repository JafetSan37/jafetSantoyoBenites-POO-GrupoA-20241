public class Rectangulo {
    double ancho, altura;
    //Método Constructor
    public Rectangulo (double x, double y) {
        ancho = x;
        altura = y;
    }
    //Método para calcular área
    public double calcularArea(){
        double a = ancho * altura;
        return a;
    }
    //Método para calcular perímetro
    public double calcularPerimetro(){
        double p = (2*altura)+(2*ancho);
        return p;
    }
}
