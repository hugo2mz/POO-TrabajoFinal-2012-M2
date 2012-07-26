package upc.poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Contacto {
    private Date fechaCliente;    //fecha en que pasa a ser cliente

    public Cliente() {
        super();
    }
    
    public Cliente(String nombres, String aPaterno, String aMaterno, String email, String dni, String telefono, String strFechaCliente) {
        super();
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.fechaCliente = formatoDelTexto.parse(strFechaCliente);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }      
    }

    public Date getFechaCliente() {
        return fechaCliente;
    }
    
    public void convertirAProspecto() {
    }
    
}
