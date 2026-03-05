package Congreso;

import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System .in);
        int numero;
        do {
            System.out.println("Que accion desea realizar.");
            System.out.println("1.Registrar asistente"+
                    "\n2.Mostrar lista de los asistentes registrados"+
                    "\n3.Mostrar estadisticas (numero de asistentes totales, numero de ponentes, numero de estudiantes,numero de profesionales"+
                    "\n4.Buscar asistente por el DNI/NIE"+
                    "\n5.Eliminar un asistente por su DNI/NIE"+
                    "\n6.Mostrar los asistentes que se han registrado antes de una fecha y hora concreta"+
                    "\n7.Salir");
            String opcion=in.nextLine();
            numero=Integer.parseInt(opcion);
            switch (numero){
                case 1:
                    System.out.println("Dime el tipo de asistente: 1.Ponente, 2.Estudiante, 3.Profesional");
                    String tipoasis=in.nextLine();
                    int tipo;
                    try {
                        tipo=Integer.parseInt(opcion);
                    }
                    catch (NumberFormatException nfe){
                        System.out.println("Debes introducir un numero");
                    }
                    break;

                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    System.out.println("Saliendo...");
                    break;
            }

        }while (numero!=7);
    }
}
