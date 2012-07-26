package upc.poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prospecto extends Contacto {
    private Date fechaContacto;

    //String nombres, String aPaterno, String aMaterno, String email, String dni, String telefono, String fechaContacto
    public Prospecto() {
        super();
    }

    public Prospecto(String nombres, String aPaterno, String aMaterno, String email, String dni, String telefono, String strFechaContacto) {
        super();
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.fechaContacto = formatoDelTexto.parse(strFechaContacto);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }      
    }

    public Date getFechaContacto() {
        return fechaContacto;
    }
    
}
