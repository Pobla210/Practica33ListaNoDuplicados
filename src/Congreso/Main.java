package Congreso;

import java.lang.NumberFormatException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System .in);
        int numero;
        SistemaGestion gestion=new SistemaGestion();
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
            String DNI;
            numero=Integer.parseInt(opcion);

            switch (numero){
                case 1:
                    System.out.println("Dime el tipo de asistente: 1.Ponente, 2.Estudiante, 3.Profesional");
                    String tipoasis=in.nextLine();
                    int tipo=0;
                    try {
                        tipo=Integer.parseInt(tipoasis);
                    }
                    catch (NumberFormatException nfe){
                        System.out.println("Debes introducir un numero");
                    }
                    System.out.println("Dime el DNI: ");
                    String DNINIE= in.nextLine();

                    System.out.println("Dime el nombre: ");
                    String nombre=in.nextLine();

                    System.out.println("Dime los apellidos: ");
                    String apellidos=in.nextLine();

                    System.out.println("Dime el email: ");
                    String email=in.nextLine();

                    LocalDateTime fregistro=LocalDateTime.now();

                    String especialidad="";
                    String empresa="";
                    String cargo="";
                    String centroeducacion="";

                    switch (tipo){
                        case 1:
                            System.out.println("Dime la especialidad: ");
                            especialidad=in.nextLine();
                            break;
                        case 2:
                            System.out.println("Dime el centro educativo: ");
                            centroeducacion=in.nextLine();
                            break;
                        case 3:
                            System.out.println("Dime la empresa: ");
                            empresa= in.nextLine();

                            System.out.println("Dime el cargo: ");
                            cargo= in.nextLine();
                            break;
                        default:
                            System.out.println("Tipo de asistente invalido");
                            break;
                    }
                    try{
                        gestion.registrarAsistente(tipo,DNINIE,nombre,apellidos,email,fregistro,especialidad,empresa,cargo,centroeducacion);
                        System.out.println("Asistente registrado correctamente");
                    }
                    catch (UsuarioInvalidoException uie){
                        System.out.println(uie.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Como los quieres ordenar: 1)Por nombre 2)Por apellido 3)Por fecha");
                    String orden=in.nextLine();
                    int orden2=0;
                    try {
                        orden2=Integer.parseInt(orden);
                    }
                    catch (NumberFormatException nfe){
                        System.out.println("Debes introducir un numero");
                    }
                    gestion.mostrarAsistentes(orden2);
                case 3:
                    gestion.mostrarEstadisticas();
                    break;
                case 4:
                    System.out.println("Dime el DNI que deseas buscar");
                    DNI= in.nextLine();
                    try {
                        System.out.println(gestion.buscarDNI(DNI));
                    }
                    catch (UsuarioInvalidoException uie){
                        System.out.println("El dni que intentas buscar no es valido");
                    }
                    break;
                case 5:
                    System.out.println("Dime el DNI que deseas buscar");
                    DNI= in.nextLine();

                    try{
                        gestion.eliminarAsistente(DNI);
                    }
                    catch (UsuarioInvalidoException uie){
                        System.out.println("El dni que intentas buscar no es valido");
                    }
                    break;
                case 6:
                    System.out.println("Dime la fecha y la hora que deseas buscar: ");
                    String fechora= in.nextLine();
                    DateTimeFormatter patron=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                    try {
                        LocalDateTime fechalimite=LocalDateTime.parse(fechora,patron);
                        gestion.mostrarAsistentesAntesHora(fechalimite);
                    }
                    catch (DateTimeParseException dtpe){
                        System.out.println("Formato de fecha invalido");
                    }
                case 7:
                    System.out.println("Saliendo...");
                    break;
            }

        }while (numero!=7);
    }
}
