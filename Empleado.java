public class Empleado {
    double sueldoBase, bonificacion;
    double horasExtras;
    //Método constructor
    public Empleado(double sueldoBase, double bonificacion, double horasextras) {
        this.sueldoBase = sueldoBase;
        this.bonificacion = bonificacion;
        this.horasExtras = horasextras;
    }
    //Sobrecarga de métodos
    public double salarioTotal(double sueldoBase){
        return sueldoBase;
    }
    public double salarioTotal(double sueldoBase, double bonificacion){
        double salario=0;
        return salario = sueldoBase + bonificacion;
    }
    public double salarioTotal(double sueldoBase, double bonificacion, double horasExtras){
        double salario=0;
        return salario = sueldoBase + bonificacion + (horasExtras*20);
    }
}
