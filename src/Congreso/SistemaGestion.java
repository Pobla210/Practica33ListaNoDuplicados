package Congreso;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SistemaGestion {
    protected int contaponentes=0;
    protected int contaestudiantes=0;
    protected int contaprofesionales=0;
    protected int tipo;
    ArrayList<Asistentes> listaasistentes=new ArrayList<>();

    public void registrarAsistente(int tipo, String dnienie, String nombre, String apellidos,
                                   String email, LocalDateTime fregistro, String especialidad,
                                   String empresa,String cargo,String centroeducativo)throws UsuarioInvalidoException{
        Asistentes asis;
        switch (tipo){
            case 1:
                asis=new Ponentes(dnienie,nombre,apellidos,email,fregistro,especialidad);
                listaasistentes.add(asis);
                contaponentes++;
                break;
            case 2:
                asis=new Estudiante(dnienie, nombre, apellidos, email, fregistro, centroeducativo);
                listaasistentes.add(asis);
                contaestudiantes++;
                break;
            case 3:
                asis=new Profesionales(dnienie, nombre, apellidos, email, fregistro, empresa, cargo);
                listaasistentes.add(asis);
                contaprofesionales++;
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
}
