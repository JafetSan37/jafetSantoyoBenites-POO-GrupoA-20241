public class Empleado {
    double sueldoBase, bonificacion;
    double horasextras;
    //Método constructor

    public Empleado(double sueldoBase, double bonificacion, int horasextras) {
        this.sueldoBase = sueldoBase;
        this.bonificacion = bonificacion;
        this.horasextras = horasextras;
    }
    //Sobrecarga de métodos
    public double salarioTotal(double sueldoBase){
        return sueldoBase;
    }
    public double salarioTotal(double sueldoBase, double bonificacion){
        double salario=0;
        return salario = sueldoBase + bonificacion;
    }
    public double salarioTotal(double sueldoBase, double bonificacion, float horasextras){
        double salario=0;
        this.horasextras=(double)horasextras;
        return salario = sueldoBase + bonificacion + (horasextras*20);
    }
}
