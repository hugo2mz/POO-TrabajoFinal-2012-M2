package upc.poo;

public abstract class Contacto {
    protected String nombres;
    protected String aPaterno;
    protected String aMaterno;
    protected String email;
    protected String dni;
    protected String telefono;
    
    public Contacto() {
        this.nombres = "";
        this.aPaterno = "";
        this.aMaterno = "";
        this.email = "";
        this.dni = "";
        this.telefono = "";        
    }
    
    //public abstract double darDeAlta(String nombres, String aPaterno, String email);    
    //public abstract double darDeAlta();    
    //public abstract double buscar();    
    //public abstract double eliminar();
    
    public String getNombres() {
        return nombres;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }
    
}
