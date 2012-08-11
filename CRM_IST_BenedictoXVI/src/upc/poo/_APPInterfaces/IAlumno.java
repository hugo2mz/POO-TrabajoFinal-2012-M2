package upc.poo._APPInterfaces;

import java.util.ArrayList;
import java.util.Date;

public interface IAlumno {
    
    public String getDni();
    public String getaMaterno();
    public String getaPaterno();
    public String getNombres();
    public String getEmail();
    public String getTelefono();
    public String getCelular();
    public String getFlagTipoAlumno();
    public Date getFechaCliente();
    public Date getFechaContacto();
    public String getFechaCliente(String formato);
    public String getFechaContacto(String formato);
    
    //public ArrayList<ICliente> getDBClientes();
    //public ArrayList<ICliente> getListaProspectos();
    public ArrayList getListaProspectos();
    public ArrayList getListaClientes();
    public ArrayList buscadorRegistros(String flagTipoAlumno, String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular);
    public boolean nuevoRegistro(String flagTipoAlumno, String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular);
    public boolean eliminarRegistro(String cod);
    public boolean modificarRegistro(String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular);
    public boolean convertirRegistro(String dni, String getFlagTipoAlumnoOLD);
    //public boolean modificarRegistro(String flagTipoAlumno, String flagTipoAlumnoOLD, String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular);
    public IAlumno buscarRegistro(String cod);
    
    
    /*
    public void eliminarProspecto();
    public void eliminarCliente();
    public void convertirAprospecto();
    public void convertirAcliente();
    */

    //public abstract double darDeAlta(String nombres, String aPaterno, String email);    
    //public abstract double darDeAlta();    
    //public abstract double buscar();    
    //public abstract double eliminar();

}
