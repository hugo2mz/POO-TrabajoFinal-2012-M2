package upc.poo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import upc.poo._APPInterfaces.IAlumno;
import upc.poo._DB.DBAlumno;

public class Alumno implements IAlumno, Comparator {
    private String dni;
    private String nombres;
    private String aPaterno;
    private String aMaterno;
    private String email;
    private String telefono;
    private String celular;
    private String flagTipoAlumno; //El tipo puede ser: P="PROSPECTO" ó C="CLIENTE"
    private Date fechaContacto;    //fecha en que es dado de alta como prospecto
    private Date fechaCliente;    //fecha en que pasa a ser cliente   
    
    private ArrayList<GrupoDeEstudio> grupoDeEstudio;

    public Alumno() {
        //Relación de asociación con GrupoDeEstudio para tener lista de GrupoDeEstudio's en el q está incrito el alumno
        this.grupoDeEstudio = new ArrayList<GrupoDeEstudio>();
    }

    public Alumno(String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular, String flagTipoAlumno, String strFechaContacto, String strFechaCliente) {
        //Relación de asosiación con GrupoDeEstudio
        this.grupoDeEstudio = new ArrayList<GrupoDeEstudio>();
        
        this.dni = dni;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.email = email;
        this.telefono = telefono;
        this.celular = celular;
        this.flagTipoAlumno = flagTipoAlumno;
        //this.fechaContacto = fechaContacto;
        //this.fechaCliente = fechaCliente;
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if(flagTipoAlumno.equals("C")) {
                this.fechaCliente = formatoDelTexto.parse(strFechaCliente);
            } else if(flagTipoAlumno.equals("P")) {
                this.fechaContacto = formatoDelTexto.parse(strFechaContacto);
            } else {
                this.fechaContacto = formatoDelTexto.parse(strFechaContacto);//Si es cualquir otro caracter será del tipo Prospecto
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }        
    }

    public Alumno(String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular, String flagTipoAlumno, Date fechaComodin) {
        //Relación de asosiación con GrupoDeEstudio
        this.grupoDeEstudio = new ArrayList<GrupoDeEstudio>();
        
        this.dni = dni;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.email = email;
        this.telefono = telefono;
        this.celular = celular;
        this.flagTipoAlumno = flagTipoAlumno;
        
        if (flagTipoAlumno.equals("C"))
            this.fechaCliente = fechaComodin;
        else
            this.fechaContacto = fechaComodin;
    }

    public String getDni() {
        return dni;
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

    public Date getFechaCliente() {
        return fechaCliente;
    }

    public Date getFechaContacto() {
        return fechaContacto;
    }

    public String getFlagTipoAlumno() {
        return flagTipoAlumno;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String getCelular() {
        return celular;
    }

    public String getFechaCliente(String formato) {        
        return new SimpleDateFormat(formato).format(fechaCliente);
    }

    public String getFechaContacto(String formato) {        
        return new SimpleDateFormat(formato).format(fechaContacto);
    }

    /*******************SETTERS**************************/
    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaCliente(Date fechaCliente) {
        this.fechaCliente = fechaCliente;
    }

    public void setFechaContacto(Date fechaContacto) {
        this.fechaContacto = fechaContacto;
    }

    public void setFlagTipoAlumno(String flagTipoAlumno) {
        this.flagTipoAlumno = flagTipoAlumno;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    /***********OPERACIONES CON LA BD*************/
    
    /*
    public static void main(String[] args) {
        String cod = "12345611";
        
        Cliente cliente1 = new Cliente();
        cliente1 = buscarRegistro(cod);
        
        System.out.println( "Eliminar: " + cliente1.getNombres() );
        System.out.println( "Eliminar: " + eliminarRegistro(cod) );
    }
    * 
    */
    
    //public static ArrayList<ICliente> iniciarDBClientes() {
    //public ArrayList<ICliente> getDBClientes() {
        //DBClientes clientes = new DBClientes();
        //return DBClientes.simulateDBCientes();
    //    DBClientes.simulateDBCientes();
    //}
    
    public boolean nuevoRegistro(String flagTipoAlumno, String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular) {
        ArrayList<IAlumno> alumnos = DBAlumno.conectarDBAlumnos();
        //String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular, String flagTipoAlumno, String fechaComodin
        try {
            alumnos.add( new Alumno(dni, nombres, aPaterno, aMaterno, email, telefono, celular, flagTipoAlumno, new Date()) );
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean modificarRegistro(String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular) {
    //public ICliente modificarRegistro(String dni, String nombres) {    
        Alumno alumno = buscarRegistro(dni);
        //int i = alumnos.indexOf(alumno);
        try {
            //if(flagTipoAlumnoOLD.equals("P") && flagTipoAlumno.equals("C"))
            //    alumno.setFechaCliente(new Date());
            //alumno.setFlagTipoAlumno(flagTipoAlumno);
            alumno.setNombres(nombres);
            alumno.setaPaterno(aPaterno);
            alumno.setaMaterno(aMaterno);
            alumno.setEmail(email);
            alumno.setTelefono(telefono);
            alumno.setCelular(celular);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean convertirRegistro(String dni, String flagTipoAlumnoOLD) {
        Alumno alumno = buscarRegistro(dni);
        try {
            if (flagTipoAlumnoOLD.equals("C")) {
                alumno.setFlagTipoAlumno("P");
                alumno.setFechaContacto(new Date());
                //System.out.println("AAAA");
            } else {
                alumno.setFlagTipoAlumno("C");
                alumno.setFechaCliente(new Date());
                //System.out.println("BBBB");
            }
        } catch (Exception e) {
            //System.out.println("ERROOR!!! " + e);
            return false;
        }
        return true;
    }
    
    public boolean eliminarRegistro(String cod) {
        ArrayList<Alumno> alumnos = DBAlumno.conectarDBAlumnos();

        Alumno alumno = buscarRegistro(cod);        
        return alumnos.remove(alumno);
    }

    public Alumno buscarRegistro(String cod) {
        ArrayList<Alumno> alumnos = DBAlumno.conectarDBAlumnos();

        Alumno alumnoEncontrado = null;
        for(Alumno alumno:alumnos) {
            if (alumno.getDni().equals(cod)) {
                alumnoEncontrado = alumno;
                break;
            }
        }
        return alumnoEncontrado;
    } 
    
    public ArrayList getListaProspectos() {
        ArrayList<IAlumno> alumnos = DBAlumno.conectarDBAlumnos();
        //ArrayList<ICliente> alumnos = alumnos.simulateDBCientes();
        
        ArrayList<IAlumno> tmp_alumnos = new ArrayList<IAlumno>();
        
        for(int i = 0; i< alumnos.size();i++) {
            if(alumnos.get(i).getFlagTipoAlumno().equals("P")) {   //Filtra los del Tipo Prospecto
                tmp_alumnos.add(alumnos.get(i));
            }
        }
        Collections.sort( tmp_alumnos, new Alumno() );//retorna el array alumnos completo, ordenado por fecha de Contacto
        return tmp_alumnos;
    }

    public ArrayList getListaClientes() {
        ArrayList<IAlumno> alumnos = DBAlumno.conectarDBAlumnos();

        ArrayList<IAlumno> tmp_alumnos = new ArrayList<>();
        
        for (int i = 0; i< alumnos.size();i++) {
            if(alumnos.get(i).getFlagTipoAlumno().equals("C")) {   //Filtra los del Tipo Cliente
                tmp_alumnos.add(alumnos.get(i));
            }
        }
        Collections.sort(tmp_alumnos, new Alumno());//retorna el array alumnos completo, ordenado por fecha de Contacto
        return tmp_alumnos;
    }

    public ArrayList buscadorRegistros(String flagTipoAlumno, String dni, String nombres, String aPaterno, String aMaterno, String email, String telefono, String celular) {
        ArrayList<Alumno> alumnos = DBAlumno.conectarDBAlumnos();

        ArrayList<IAlumno> tmp_alumnos1 = new ArrayList<>();
        ArrayList<IAlumno> tmp_alumnos2 = new ArrayList<>();
        ArrayList<IAlumno> tmp_alumnos3 = new ArrayList<>();
        ArrayList<IAlumno> tmp_alumnos4 = new ArrayList<>();
        ArrayList<IAlumno> tmp_alumnos5 = new ArrayList<>();
        ArrayList<IAlumno> tmp_alumnos6 = new ArrayList<>();
        ArrayList<IAlumno> tmp_alumnos7 = new ArrayList<>();
        ArrayList<IAlumno> tmp_alumnos8 = new ArrayList<>();
        
        //Filtrar primero por flagTipoAlumno
        for(int i = 0; i< alumnos.size(); i++) {
            //if(alumnos.get(i).getFlagTipoCliente().equals("P"))
            if(alumnos.get(i).getFlagTipoAlumno().equals(flagTipoAlumno))
                tmp_alumnos1.add(alumnos.get(i));
        }
        
        if(! dni.trim().isEmpty())  //Si se ingresa DNI
            for(int i = 0; i< tmp_alumnos1.size(); i++) {
                if(tmp_alumnos1.get(i).getDni().equalsIgnoreCase(dni))
                    tmp_alumnos2.add(tmp_alumnos1.get(i));
            }
        else
            tmp_alumnos2.addAll(tmp_alumnos1);
            
        if(! nombres.trim().isEmpty())  //Si se ingresa Nombres
            for(int i = 0; i< tmp_alumnos2.size(); i++) {
                if(tmp_alumnos2.get(i).getNombres().equalsIgnoreCase(nombres))
                    tmp_alumnos3.add(tmp_alumnos2.get(i));
            }        
        else
            tmp_alumnos3.addAll(tmp_alumnos2);
        
        if(! aPaterno.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_alumnos3.size(); i++) {
                if(tmp_alumnos3.get(i).getaPaterno().equalsIgnoreCase(aPaterno))
                    tmp_alumnos4.add(tmp_alumnos3.get(i));
            }        
        else
            tmp_alumnos4.addAll(tmp_alumnos3);
        
        if(! aMaterno.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_alumnos4.size(); i++) {
                if(tmp_alumnos4.get(i).getaMaterno().equalsIgnoreCase(aMaterno))
                    tmp_alumnos5.add(tmp_alumnos4.get(i));
            }        
        else
            tmp_alumnos5.addAll(tmp_alumnos4);

        if(! email.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_alumnos5.size(); i++) {
                if(tmp_alumnos5.get(i).getEmail().equalsIgnoreCase(email))
                    tmp_alumnos6.add(tmp_alumnos5.get(i));
            }        
        else
            tmp_alumnos6.addAll(tmp_alumnos5);
        
        if(! telefono.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_alumnos6.size(); i++) {
                if(tmp_alumnos6.get(i).getTelefono().equalsIgnoreCase(telefono))
                    tmp_alumnos7.add(tmp_alumnos6.get(i));
            }        
        else
            tmp_alumnos7.addAll(tmp_alumnos6);

        if(! celular.trim().isEmpty())  //Si se ingresa aPaterno
            for(int i = 0; i< tmp_alumnos7.size(); i++) {
                if(tmp_alumnos7.get(i).getCelular().equalsIgnoreCase(celular))
                    tmp_alumnos8.add(tmp_alumnos7.get(i));
            }        
        else
            tmp_alumnos8.addAll(tmp_alumnos7);        
        
        Collections.sort(tmp_alumnos8, new Alumno());//retorna el array alumnos completo, ordenado por fecha de Contacto
        return tmp_alumnos8;
    }

    
    //Define el orden natural
    public int compare(Object o1, Object o2) {
        IAlumno alumno1 = (Alumno) o1;
        IAlumno alumno2 = (Alumno) o2;
        
        if(alumno1.getFlagTipoAlumno().equals("C")) {
            return alumno1.getFechaCliente().compareTo(alumno2.getFechaCliente());
        } else if(alumno1.getFlagTipoAlumno().equals("P")) {
            return alumno1.getFechaContacto().compareTo(alumno2.getFechaContacto());
        } else {
            return alumno1.getFechaContacto().compareTo(alumno2.getFechaContacto());
        }
    }    
    
    
}
