package Congreso;
import java.time.LocalDateTime;

public class Estudiante extends Asistentes {
    protected String centroeducativo;
    public Estudiante(String dnienie,String nombre,String apellidos,String email,LocalDateTime fregistro,String centroeducativo) throws UsuarioInvalidoException{
        super(dnienie,nombre,apellidos,email,fregistro);
        this.centroeducativo=centroeducativo;
    }
    @Override
    public String toString() {
        return super.toString() + ", Centro educativo: " + centroeducativo;
    }
}
