package Congreso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Asistentes {
    protected String dnienie;
    protected String dninievalidador="^(?:\\d{8}[A-HJ-NP-TV-Z]|[XYZ]\\d{7}[A-HJ-NP-TV-Z])$";
    protected String nombre;
    protected String apellidos;
    protected String email;
    protected String emailvalidacion="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public LocalDateTime getFregistro() {
        return fregistro;
    }

    protected LocalDateTime fregistro;

    public String getDnienie() {
        return dnienie;
    }

    public void setDnienie(String dnienie) {
        this.dnienie = dnienie;
    }

    public Asistentes(String dnienie,String nombre,String apellidos,String email,LocalDateTime fregistro) throws UsuarioInvalidoException {
        if (!dnienie.matches(dninievalidador)){
            throw new UsuarioInvalidoException("El DNI/NIE no tiene un formato valido.");
        }
        else {
            this.dnienie=dnienie;
        }
        this.nombre=nombre;
        this.apellidos=apellidos;
        if (!email.matches(emailvalidacion)){
            throw new UsuarioInvalidoException("Formato incorrecto.Prueba de nuevo.");
        }
        else {
            this.email=email;
        }
        this.fregistro=LocalDateTime.now();
    }
    @Override
    public String toString() {
        DateTimeFormatter patron=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "DNI/NIE: " + dnienie +
                ", Nombre: " + nombre + " " + apellidos +
                ", Email: " + email +
                ", Fecha registro: " + fregistro.format(patron);
    }
}
