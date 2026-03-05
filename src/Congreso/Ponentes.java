package Congreso;

import java.time.LocalDateTime;

public class Ponentes extends Asistentes  {
    protected String especialidad;
    public Ponentes(String dnienie, String nombre, String apellidos, String email, LocalDateTime fregistro,String especialidad) throws UsuarioInvalidoException{
        super(dnienie,nombre,apellidos,email,fregistro);
        this.especialidad=especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad;
    }
}
