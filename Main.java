import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        //Ejercicio Rectángulo
        double base, altura;
        //Objetos de la clase Rectángulo
        System.out.print("Hola! Ingresa la base del rectángulo: ");
        base = leer.nextDouble();
        System.out.print("Ingresa la altura del rectángulo: ");
        altura = leer.nextDouble();
        Rectangulo rectangulo1 = new Rectangulo(base, altura);
        //Cálculo de áreas y perímetros e impresión de resultados
        System.out.printf("\nEl perímetro del rectángulo es: %.2f", rectangulo1.calcularPerimetro(base, altura));
        System.out.printf("\nEl área del rectángulo es: %.2f\n", rectangulo1.calcularArea(base, altura));
        System.out.println("\n************");

        //Ejercicio Empleado
        double sueldoBase, bonificacion, horasExtras;
        //Se solicitan los datos al usuario, y se ejecutan los métodos dependiendo de los datos recibidos
        System.out.println("\nIngresa tu sueldo: ");
        sueldoBase = leer.nextDouble();
        System.out.println("¿Tienes bonificación? S/N: ");
        char respuesta = leer.next().charAt(0);
        if (respuesta=='s'||respuesta=='S'){
            System.out.println("Ingresa tu bonificación: ");
            bonificacion = leer.nextDouble();
            System.out.println("¿Tienes horas extras? S/N: ");
            respuesta = leer.next().charAt(0);
            if (respuesta=='s'||respuesta=='S'){
                System.out.println("Ingresa las horas extras: ");
                horasExtras = leer.nextDouble();
                Empleado empleado = new Empleado(sueldoBase, bonificacion, horasExtras);
                System.out.printf("\nTu sueldo total es: %.2f", empleado.salarioTotal(sueldoBase, bonificacion, horasExtras));
            }else{
                Empleado empleado = new Empleado(sueldoBase, bonificacion, 0);
                System.out.printf("\nTu sueldo total es: %.2f", empleado.salarioTotal(sueldoBase, bonificacion));
            }
        }else{
            Empleado empleado = new Empleado(sueldoBase,0,0);
            System.out.printf("\nTu suelto total es: %.2f\n",empleado.salarioTotal(sueldoBase));
        }
        System.out.println("\n***************");

        //Ejercicio Calculadora de Impuestos
        //Creación del objeto
        CalculadoraImpuestos calculo1 = new CalculadoraImpuestos(456789, 34.89, 4.51, 3.21, 428745.89);
        //Cálculo con diferentes parámetros usando los atributos del objeto e impresión de resultados
        System.out.println("\nCálculo ingresos:");
        System.out.println(calculo1.calculadoraImp(calculo1.ingresos));
        System.out.println("Cálculo ventas y porcentaje de impuestos");
        System.out.println(calculo1.calculadoraImp(calculo1.ventas, calculo1.porcentajeImpuestos));
        System.out.println("Cálculo dividendos, porcentaje de impuestos y exención");
        System.out.println(calculo1.calculadoraImp(calculo1.dividendos, calculo1.porcentajeImpuestos, calculo1.exencion));
    }
}
