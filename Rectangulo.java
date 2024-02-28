public class Rectangulo {
    double base, altura;
    //Métodos constructores con sobrecarga
    public Rectangulo(int base, int altura){
        this.base = (int)base;
        this.altura = (int)altura;
    }
    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    //Métodos para calcular área y perímetro
    public int calcularPerimetro(int h, int base1){
        h = (int)altura;
        base1 = (int)base;
        int perimetro;
        return perimetro = (2*base1) + (2*h);
    }
    public double calcularPerimetro(double h, double altura){
        double perimetro;
        return perimetro = (2*base) + (2*altura);
    }
    public int calcularArea(int altura, int base){
        int h = (int)altura, base1 = (int)base;
        int area;
        return area = h*base1;
    }
    public double calcularArea(double base, double altura){
        double area;
        return area = base*altura;
    }
}
