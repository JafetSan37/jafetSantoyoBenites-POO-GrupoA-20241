public class CalculadoraImpuestos {
    int ingresos;
    double porcentajeImpuestos, dividendos, exencion, ventas;
    //Métodos constructores

    public CalculadoraImpuestos(int ingresos, double porcentajeImpuestos, double dividendos, double exencion, double ventas) {
        this.ingresos = ingresos;
        this.porcentajeImpuestos = porcentajeImpuestos;
        this.dividendos = dividendos;
        this.exencion = exencion;
        this.ventas = ventas;
    }

    //Métodos
    public double calculadoraImp(int ingresos){
        double ingreso = (double) ingresos;
        return ingreso += 0.15;
    }
    public double calculadoraImp(double ventas, double porcentajeImpuestos){
        double impuesto=0;
        return impuesto = ventas * (porcentajeImpuestos/100);
    }
    public double calculadoraImp(double dividendos, double porcentajeImpuestos, double exencion){
        double impuesto=0;
        impuesto = dividendos * (porcentajeImpuestos/100);
        if(impuesto>exencion){
            return impuesto -= exencion;
        }else{
            return impuesto=0;
        }
    }
}
