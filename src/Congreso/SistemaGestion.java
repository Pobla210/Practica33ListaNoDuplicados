package Congreso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class SistemaGestion {
    protected int contaponentes=0;
    protected int contaestudiantes=0;
    protected int contaprofesionales=0;
    protected int contaasistentes=0;
    ArrayList<Asistentes> listaasistentes=new ArrayList<>();
    TreeSet<Asistentes> listaasistentesnombre=new TreeSet<>(Comparator.comparing(Asistentes::getNombre).thenComparing(Asistentes::getDnienie));
    TreeSet<Asistentes> listaasistentesapellido=new TreeSet<>(Comparator.comparing(Asistentes::getApellidos).thenComparing(Asistentes::getDnienie));
    TreeSet<Asistentes> listaasistentesfecha=new TreeSet<>(Comparator.comparing(Asistentes::getFregistro).thenComparing(Asistentes::getDnienie));
    public void registrarAsistente(int tipo, String dnienie, String nombre, String apellidos,
                                   String email, LocalDateTime fregistro, String especialidad,
                                   String empresa,String cargo,String centroeducativo)throws UsuarioInvalidoException{
        Asistentes asis;

        switch (tipo){
            case 1:
                asis=new Ponentes(dnienie,nombre,apellidos,email,fregistro,especialidad);
                listaasistentes.add(asis);
                listaasistentesnombre.add(asis);
                listaasistentesapellido.add(asis);
                listaasistentesfecha.add(asis);
                contaponentes++;
                contaasistentes++;
                break;
            case 2:
                asis=new Estudiante(dnienie, nombre, apellidos, email, fregistro, centroeducativo);
                listaasistentes.add(asis);
                listaasistentesnombre.add(asis);
                listaasistentesapellido.add(asis);
                listaasistentesfecha.add(asis);
                contaestudiantes++;
                contaasistentes++;
                break;
            case 3:
                asis=new Profesionales(dnienie, nombre, apellidos, email, fregistro, empresa, cargo);
                listaasistentes.add(asis);
                listaasistentesnombre.add(asis);
                listaasistentesapellido.add(asis);
                listaasistentesfecha.add(asis);
                contaprofesionales++;
                contaasistentes++;
                break;
            default:
                throw new UsuarioInvalidoException("Tipo de asistente invalido");
        }
    }

    public void mostrarAsistentes(int orden){
        switch (orden){
            case 1:
                mostrarPorNombre();
                break;
            case 2:
                mostrarPorApellidos();
                break;
            case 3:
                mostrarPorFecha();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void mostrarPorNombre(){
        for (Asistentes a : listaasistentesnombre){
            System.out.println(a);
        }
    }

    public void mostrarPorApellidos(){
        for (Asistentes a : listaasistentesapellido){
            System.out.println(a);
        }
    }

    public void mostrarPorFecha(){
        for (Asistentes a : listaasistentesfecha){
            System.out.println(a);
        }
    }

    public String mostrarEstadisticas(){
        return "Numero de asistentes: "+contaasistentes+
                "\nNumero de estudiantes: "+contaestudiantes+
                "\nNumero de ponentes: "+contaponentes+
                "\nNumero de profesionales: "+contaprofesionales;
    }

    public Asistentes buscarDNI(String DNI)throws UsuarioInvalidoException{
        DNI=DNI.toUpperCase();
        if (!DNI.matches("^(?:\\d{8}[A-HJ-NP-TV-Z]|[XYZ]\\d{7}[A-HJ-NP-TV-Z])$")){
            throw new UsuarioInvalidoException("El dni que intentas buscar no es valido");
        }
        else {
            for (int i=0;i<listaasistentes.size();i++){
                if (listaasistentes.get(i).getDnienie().equalsIgnoreCase(DNI)){
                    return listaasistentes.get(i);
                }
            }
            return null;
        }
    }

    public void eliminarAsistente(String DNI)throws UsuarioInvalidoException{
        DNI=DNI.toUpperCase();
        if (!DNI.matches("^(?:\\d{8}[A-HJ-NP-TV-Z]|[XYZ]\\d{7}[A-HJ-NP-TV-Z])$")){
            throw new UsuarioInvalidoException("El dni que intentas buscar no es valido");
        }
        else {
            for (int i=0;i<listaasistentes.size();i++){
                    Asistentes listatree=listaasistentes.get(i);
                    if (listaasistentes.get(i).getDnienie().equalsIgnoreCase(DNI)){
                        listaasistentesnombre.remove(listatree);
                        listaasistentesapellido.remove(listatree);
                        listaasistentesfecha.remove(listatree);
                        listaasistentes.remove(i);
                        System.out.println("Asistente eliminado correctamente");
                        return;
                    }
            }
        }
        throw new UsuarioInvalidoException("No existe ese usuario");
    }

    public void mostrarAsistentesAntesHora(LocalDateTime hora){
        boolean encontrado=false;
        for (int i=0;i<listaasistentes.size();i++){
            if (listaasistentes.get(i).getFregistro().isBefore(hora)){
                System.out.println(listaasistentes.get(i));
                encontrado=true;
            }
        }
        if (!encontrado){
            System.out.println("No hay ningun asistente antes de esa fecha");
        }
    }
}
