package upc.poo._APPInterfaces;

import java.util.ArrayList;
import upc.poo.controller.AlumnoCTRL;

public interface IAlumnoVIEW {
    void setControlador(AlumnoCTRL c);
    void arranca();
    
    void escribeCambio(String s);
    void escribeCambio(ArrayList<IAlumno> lista);
    void procesaNuevaOperacion();
    void procesaEditarRegistro();
    void menuEditarRegistro();
    
    public String getTextBox(String mensajeAmostrar);
    public String getTextBoxF(String mensajeAmostrar);
    public String getTextBoxHidden(int i);
    public String getDialogYesNo(String mensajeAmostrar);
    
    //Constantes que definen las posibles operaciones:
    static final int BUSCARCLIENTES = 1;
    static final int BUSCARPROSPECTO = 2;
    static final int EDITARREGISTRO = 3;
    static final int ELIMINARREGISTRO = 4;
    static final int VERLISTASOLOCLIENTES = 5;
    static final int VERLISTASOLOPROSPECTOS = 6;
    static final int CREARNUEVOCLIENTE = 7;
    static final int CONVERTIRREGISTRO = 8;
    static final int NUEVOPROSPECTO = 9;
    static final int NUEVOCLIENTE = 10;
    
}
