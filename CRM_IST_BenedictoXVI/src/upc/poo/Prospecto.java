package upc.poo;

import java.util.Date;

public class Prospecto {
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String email;
    private String dni;
    private String telefono;
    private String celular;
    private String fechaContacto;

    public Prospecto(String nombre, String aPaterno, String aMaterno, String email, String dni, String telefono, String celular, String fechaContacto) {
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.celular = celular;
        this.fechaContacto = fechaContacto;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public String getCelular() {
        return celular;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getFechaContacto() {
        return fechaContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    

    
    
    
}
