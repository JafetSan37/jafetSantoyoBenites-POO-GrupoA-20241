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
    public int calcularPerimetro(int perimetro){
        int h = (int)altura, base1 = (int)base;
        return perimetro = (2*base1) + (2*h);
    }
    public double calcularPerimetro(double perimetro){
        return perimetro = (2*base) + (2*altura);
    }
    public int calcularArea(int area){
        int h = (int)altura, base1 = (int)base;
        return area = h*base1;
    }
    public double calcularArea(double area){
        return area = base*altura;
    }
}
