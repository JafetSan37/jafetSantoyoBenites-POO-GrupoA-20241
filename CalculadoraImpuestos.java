public class CalculadoraImpuestos {
    int ingresos;
    double porcentajeImpuestos, dividendos, exencion, ventas;
    //Método constructor y sobrecargas
    public CalculadoraImpuestos(int ingresos) {
        this.ingresos = ingresos;
    }

    public CalculadoraImpuestos(double porcentajeImpuestos, double ventas) {
        this.porcentajeImpuestos = porcentajeImpuestos;
        this.ventas = ventas;
    }

    public CalculadoraImpuestos(double porcentajeImpuestos, double dividendos, double exencion) {
        this.porcentajeImpuestos = porcentajeImpuestos;
        this.dividendos = dividendos;
        this.exencion = exencion;
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
