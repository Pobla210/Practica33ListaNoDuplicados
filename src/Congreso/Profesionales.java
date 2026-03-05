package Congreso;

import java.time.LocalDateTime;

public class Profesionales extends Asistentes{
    protected String empresa;
    protected String cargo;
    public Profesionales(String dnienie, String nombre, String apellidos, String email, LocalDateTime fregistro,String empresa,String cargo) throws UsuarioInvalidoException{
        super(dnienie,nombre,apellidos,email,fregistro);
        this.empresa=empresa;
        this.cargo=cargo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Empresa: " + empresa + ", Cargo: " + cargo;
    }
}
