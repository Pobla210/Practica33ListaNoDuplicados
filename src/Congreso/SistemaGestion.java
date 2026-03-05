package Congreso;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SistemaGestion {
    protected int contaponentes=0;
    protected int contaestudiantes=0;
    protected int contaprofesionales=0;
    protected int contaasistentes=0;
    protected int tipo;
    ArrayList<Asistentes> listaasistentes=new ArrayList<>();
    ArrayList<Ponentes> listaponentes=new ArrayList<>();
    ArrayList<Estudiante> listaestudiantes=new ArrayList<>();
    ArrayList<Profesionales> listaprofesionales=new ArrayList<>();

    public void registrarAsistente(int tipo, String dnienie, String nombre, String apellidos,
                                   String email, LocalDateTime fregistro, String especialidad,
                                   String empresa,String cargo,String centroeducativo)throws UsuarioInvalidoException{
        Asistentes asis;

        switch (tipo){
            case 1:
                asis=new Ponentes(dnienie,nombre,apellidos,email,fregistro,especialidad);
                listaasistentes.add(asis);
                listaponentes.add((Ponentes) asis);
                contaponentes++;
                contaasistentes++;
                break;
            case 2:
                asis=new Estudiante(dnienie, nombre, apellidos, email, fregistro, centroeducativo);
                listaasistentes.add(asis);
                listaestudiantes.add((Estudiante)asis);
                contaestudiantes++;
                contaasistentes++;
                break;
            case 3:
                asis=new Profesionales(dnienie, nombre, apellidos, email, fregistro, empresa, cargo);
                listaasistentes.add(asis);
                listaprofesionales.add((Profesionales)asis);
                contaprofesionales++;
                contaasistentes++;
                break;
            default:
                throw new UsuarioInvalidoException("Tipo de asistente invalido");
        }
    }

    public void mostrarAsistentes(){
        for (Asistentes asi: listaasistentes){
            System.out.println(asi);
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
                    if (listaasistentes.get(i).getDnienie().equalsIgnoreCase(DNI)){
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
