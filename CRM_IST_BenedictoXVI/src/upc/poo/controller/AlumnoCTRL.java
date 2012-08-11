package upc.poo.controller;

import upc.poo.model.Alumno;
import java.util.*;
import upc.poo._APPInterfaces.IAlumno;
import upc.poo._APPInterfaces.IAlumnoVIEW;

public class AlumnoCTRL {
//public class ClienteCTRL implements Comparator {    
    
    private IAlumnoVIEW vistaAlumno;  //Inferface para cumunicarse con la clase ClienteWIEW (Vista)
    private IAlumno modeloAlumno;     //Inferface para cumunicarse con la clase Cliente (Modelo)
    //private Cliente modeloAlumno;
    
    //private static ArrayList<ICliente> clientes = Cliente.getDBClientes();

    public AlumnoCTRL() {}
    
    public AlumnoCTRL(IAlumnoVIEW vistaCliente, IAlumno modeloCliente) {
        this.vistaAlumno = vistaCliente;
        this.modeloAlumno = modeloCliente;
    }
    
    /****************Maneja todos lo eventos generados en la Vista***************/
    public void ejecutor(int evento) {
        
        if (evento == IAlumnoVIEW.NUEVOPROSPECTO) {
            String mensaje = "";
            String dni = vistaAlumno.getTextBoxF("Nuevo Prospecto >> DNI");
//String flagTipoAlumno, String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular            
            if ( modeloAlumno.nuevoRegistro(
                    "P",
                    dni,
                    vistaAlumno.getTextBoxF("Nuevo Prospecto >> Nombres"),
                    vistaAlumno.getTextBoxF("Nuevo Prospecto >> Apellido Paterno"),
                    vistaAlumno.getTextBox("Nuevo Prospecto >> Apellido Materno"),
                    vistaAlumno.getTextBoxF("Nuevo Prospecto >> Email"),
                    vistaAlumno.getTextBox("Nuevo Prospecto >> Telefono"),
                    vistaAlumno.getTextBox("Nuevo Prospecto >> Celular")
            )) {
                mensaje = "Nuevo Prospecto creado: " + dni + "\t" +
                            modeloAlumno.buscarRegistro(dni).getNombres() + "\t" +
                            modeloAlumno.buscarRegistro(dni).getaPaterno() + "\t" +
                            modeloAlumno.buscarRegistro(dni).getaMaterno();                            
                vistaAlumno.escribeCambio( mensaje );
            } else {
                vistaAlumno.escribeCambio( "Error: No se pudo crear el Prospecto!!!" );  
            }    
        }
        
        if (evento == IAlumnoVIEW.NUEVOCLIENTE) {
            String mensaje = "";
            String dni = vistaAlumno.getTextBoxF("Nuevo Cliente >> DNI");
//String flagTipoAlumno, String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular            
            if ( modeloAlumno.nuevoRegistro(
                    "C",
                    dni,
                    vistaAlumno.getTextBoxF("Nuevo Cliente >> Nombres"),
                    vistaAlumno.getTextBoxF("Nuevo Cliente >> Apellido Paterno"),
                    vistaAlumno.getTextBox("Nuevo Cliente >> Apellido Materno"),
                    vistaAlumno.getTextBoxF("Nuevo Cliente >> Email"),
                    vistaAlumno.getTextBox("Nuevo Cliente >> Telefono"),
                    vistaAlumno.getTextBox("Nuevo Cliente >> Celular")
            )) {
                mensaje = "Nuevo Cliente creado: " + dni + "\t" +
                            modeloAlumno.buscarRegistro(dni).getNombres() + "\t" +
                            modeloAlumno.buscarRegistro(dni).getaPaterno() + "\t" +
                            modeloAlumno.buscarRegistro(dni).getaMaterno();                            
                vistaAlumno.escribeCambio( mensaje );
            } else {
                vistaAlumno.escribeCambio( "Error: No se pudo crear el Prospecto!!!" );  
            }    
        }

        if (evento == IAlumnoVIEW.BUSCARPROSPECTO) {
            ArrayList rs;
            rs = modeloAlumno.buscadorRegistros(
                    "P",    //"Una letra marca la diferencia"
                    vistaAlumno.getTextBox("Buscar un Prospecto >> DNI"),
                    vistaAlumno.getTextBox("Buscar un Prospecto >> Nombres"),
                    vistaAlumno.getTextBox("Buscar un Prospecto >> Apellido Paterno"),
                    vistaAlumno.getTextBox("Buscar un Prospecto >> Apellido Materno"),
                    vistaAlumno.getTextBox("Buscar un Prospecto >> Email"),
                    vistaAlumno.getTextBox("Buscar un Prospecto >> Telefono"),
                    vistaAlumno.getTextBox("Buscar un Prospecto >> Celular") 
                    );
            vistaAlumno.escribeCambio( rs );
        }
        
        if (evento == IAlumnoVIEW.ELIMINARREGISTRO) {
            String dni = vistaAlumno.getTextBoxHidden(0);   //obtener el DNI desde un campo oculto
            String prompt = "Eliminar registro >> ¿Está seguro que desea eliminar el registro?";
            String mensaje = "Registro eliminado: " + dni + "\t" + 
                            modeloAlumno.buscarRegistro(dni).getNombres() + "\t" + 
                            modeloAlumno.buscarRegistro(dni).getaPaterno() + "\t" + 
                            modeloAlumno.buscarRegistro(dni).getaMaterno();
            
            if ( vistaAlumno.getDialogYesNo(prompt).equals("SI") && modeloAlumno.eliminarRegistro(dni) )
                vistaAlumno.escribeCambio( mensaje );
            else
                vistaAlumno.escribeCambio( "Error: No se pudo eliminar!!!" );
        }

        if (evento == IAlumnoVIEW.CONVERTIRREGISTRO) {
            String dni = vistaAlumno.getTextBoxHidden(0);   //obtener el DNI desde un campo oculto
            String flagTipoAlumnoOLD = vistaAlumno.getTextBoxHidden(1);   //obtener el FLAG desde un campo oculto
            String prompt = "Convertir registro >> ¿Está seguro que desea convertirlo a ";
            String mensaje = "";
            
            if (flagTipoAlumnoOLD.equals("C"))
                prompt += "Prospecto?";
            else
                prompt += "Cliente?";
            
            if ( vistaAlumno.getDialogYesNo(prompt).equals("SI") && modeloAlumno.convertirRegistro( dni, flagTipoAlumnoOLD ) ) {
                 mensaje = "Registro convertido a " +
                            (modeloAlumno.buscarRegistro(dni).getFlagTipoAlumno().equals("C") ? "Cliente" : "Prospecto") +
                            ": " + dni + "\t" +
                            modeloAlumno.buscarRegistro(dni).getNombres() + "\t" +
                            modeloAlumno.buscarRegistro(dni).getaPaterno() + "\t" +
                            modeloAlumno.buscarRegistro(dni).getaMaterno();
                vistaAlumno.escribeCambio( mensaje );
            } else {
                vistaAlumno.escribeCambio( "Error: No se pudo convertir!!!" );
            }
        }
        
        if (evento == IAlumnoVIEW.EDITARREGISTRO) {
            //String dni = vistaAlumno.getTextBoxHidden();
            //vistaCliente.escribeCambio( dni );
            String dni = vistaAlumno.getTextBoxHidden(0);   //obtener el DNI desde un campo oculto
            //String getFlagTipoAlumnoOLD = vistaAlumno.getTextBoxHidden(1);   //obtener el getFlagTipoAlumnoOLD (ANTIGUO) desde un campo oculto
            String mensaje = "";
            
            if ( modeloAlumno.modificarRegistro(
                    //vistaAlumno.getTextBoxF("Modificar Prospecto >> TIPO (P=Prospecto | C=Cliente)"),
                    //getFlagTipoAlumnoOLD,
                    dni,
                    vistaAlumno.getTextBoxF("Modificar registro >> Nombres"),
                    vistaAlumno.getTextBoxF("Modificar registro >> Apellido Paterno"),
                    vistaAlumno.getTextBox("Modificar registro >> Apellido Materno"),
                    vistaAlumno.getTextBoxF("Modificar registro >> Email"),
                    vistaAlumno.getTextBox("Modificar registro >> Telefono"),
                    vistaAlumno.getTextBox("Modificar registro >> Celular") 
            )) {
                mensaje = "Registro modificado: " + dni + "\t" +
                            modeloAlumno.buscarRegistro(dni).getNombres() + "\t" +
                            modeloAlumno.buscarRegistro(dni).getaPaterno() + "\t" +
                            modeloAlumno.buscarRegistro(dni).getaMaterno();
                vistaAlumno.escribeCambio( mensaje );  //VERIFICAR ESTO!!! <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            } else {
                vistaAlumno.escribeCambio( "Error: No se pudo modificar!!!" );  
            }
        }

        if (evento == IAlumnoVIEW.VERLISTASOLOPROSPECTOS) {
            vistaAlumno.escribeCambio(modeloAlumno.getListaProspectos());
        }

        if (evento == IAlumnoVIEW.BUSCARCLIENTES) {
            ArrayList rs;
            rs = modeloAlumno.buscadorRegistros(
                    "C",    //"Una letra marca la diferencia"
                    vistaAlumno.getTextBox("Buscar un Registro >> DNI"),
                    vistaAlumno.getTextBox("Buscar un Registro >> Nombres"),
                    vistaAlumno.getTextBox("Buscar un Registro >> Apellido Paterno"),
                    vistaAlumno.getTextBox("Buscar un Registro >> Apellido Materno"),
                    vistaAlumno.getTextBox("Buscar un Registro >> Email"),
                    vistaAlumno.getTextBox("Buscar un Registro >> Telefono"),
                    vistaAlumno.getTextBox("Buscar un Registro >> Celular") 
                    );
            vistaAlumno.escribeCambio( rs );
        }
        
        if (evento == IAlumnoVIEW.VERLISTASOLOCLIENTES) {
            //System.out.println("GOOGLEEEEEEE");
            vistaAlumno.escribeCambio(modeloAlumno.getListaClientes());
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    

    /***************************************
    public static ArrayList getListaClientes() {
    //public ArrayList getListaClientes() {
        ArrayList<ICliente> tmp_clientes = new ArrayList<>();
        
        for (int i = 0; i< clientes.size();i++) {
            if(clientes.get(i).getFlagTipoCliente().equals("C")) {
                tmp_clientes.add(clientes.get(i));
            }
        }
        Collections.sort(tmp_clientes, new ClienteCTRL());//retorna el array clientes completo, ordenado por fecha de Contacto
        return tmp_clientes;
    }

    public static ArrayList getBuscadorProspectos(String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular) {
        ArrayList<ICliente> tmp_clientes1 = new ArrayList<>();
        ArrayList<ICliente> tmp_clientes2 = new ArrayList<>();
        ArrayList<ICliente> tmp_clientes3 = new ArrayList<>();
        ArrayList<ICliente> tmp_clientes4 = new ArrayList<>();
        ArrayList<ICliente> tmp_clientes5 = new ArrayList<>();
        ArrayList<ICliente> tmp_clientes6 = new ArrayList<>();
        ArrayList<ICliente> tmp_clientes7 = new ArrayList<>();
        ArrayList<ICliente> tmp_clientes8 = new ArrayList<>();
        
        //Filtrar sólo prospectos
        for(int i = 0; i< clientes.size(); i++) {
            if(clientes.get(i).getFlagTipoCliente().equals("P"))
                tmp_clientes1.add(clientes.get(i));
        }
        
        if(! dni.trim().isEmpty())  //Si se ingresa DNI
            for(int i = 0; i< tmp_clientes1.size(); i++) {
                if(tmp_clientes1.get(i).getDni().equalsIgnoreCase(dni))
                    tmp_clientes2.add(tmp_clientes1.get(i));
            }
        else
            tmp_clientes2.addAll(tmp_clientes1);
            
        if(! nombres.trim().isEmpty())  //Si se ingresa Nombres
            for(int i = 0; i< tmp_clientes2.size(); i++) {
                if(tmp_clientes2.get(i).getNombres().equalsIgnoreCase(nombres))
                    tmp_clientes3.add(tmp_clientes2.get(i));
            }        
        else
            tmp_clientes3.addAll(tmp_clientes2);
        
        if(! aPaterno.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_clientes3.size(); i++) {
                if(tmp_clientes3.get(i).getaPaterno().equalsIgnoreCase(aPaterno))
                    tmp_clientes4.add(tmp_clientes3.get(i));
            }        
        else
            tmp_clientes4.addAll(tmp_clientes3);
        
        if(! aMaterno.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_clientes4.size(); i++) {
                if(tmp_clientes4.get(i).getaMaterno().equalsIgnoreCase(aMaterno))
                    tmp_clientes5.add(tmp_clientes4.get(i));
            }        
        else
            tmp_clientes5.addAll(tmp_clientes4);

        if(! email.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_clientes5.size(); i++) {
                if(tmp_clientes5.get(i).getEmail().equalsIgnoreCase(email))
                    tmp_clientes6.add(tmp_clientes5.get(i));
            }        
        else
            tmp_clientes6.addAll(tmp_clientes5);
        
        if(! telefono.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_clientes6.size(); i++) {
                if(tmp_clientes6.get(i).getTelefono().equalsIgnoreCase(telefono))
                    tmp_clientes7.add(tmp_clientes6.get(i));
            }        
        else
            tmp_clientes7.addAll(tmp_clientes6);

        if(! celular.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_clientes7.size(); i++) {
                if(tmp_clientes7.get(i).getCelular().equalsIgnoreCase(celular))
                    tmp_clientes8.add(tmp_clientes7.get(i));
            }        
        else
            tmp_clientes8.addAll(tmp_clientes7);        
        
        Collections.sort(tmp_clientes8, new ClienteCTRL());//retorna el array clientes completo, ordenado por fecha de Contacto
        return tmp_clientes8;
    }

    public static ArrayList getListaProspectos() {
    //public ArrayList getListaProspectos() {
        ArrayList<ICliente> tmp_clientes = new ArrayList<ICliente>();
        
        for(int i = 0; i< clientes.size();i++) {
            if(clientes.get(i).getFlagTipoCliente().equals("P")) {
                tmp_clientes.add(clientes.get(i));
            }
        }
        Collections.sort(tmp_clientes, new ClienteCTRL());//retorna el array clientes completo, ordenado por fecha de Contacto
        return tmp_clientes;
    }

    public void nuevoCliente(Cliente cliente) {
    //public void nuevoCliente(ICliente cliente){
        clientes.add(cliente);    //agrega un cliente al array de clientes
    }    

    public int compare(Object o1, Object o2) { //Define el orden natural
        ICliente cliente1 = (Cliente) o1;
        ICliente cliente2 = (Cliente) o2;
        
        if(cliente1.getFlagTipoCliente().equals("C")) {            
            return cliente1.getFechaCliente().compareTo(cliente2.getFechaCliente());
        } else if(cliente1.getFlagTipoCliente().equals("P")) {
            return cliente1.getFechaContacto().compareTo(cliente2.getFechaContacto());
        } else {
            return cliente1.getFechaContacto().compareTo(cliente2.getFechaContacto());
        }
    }
    *******************************************/    

}
