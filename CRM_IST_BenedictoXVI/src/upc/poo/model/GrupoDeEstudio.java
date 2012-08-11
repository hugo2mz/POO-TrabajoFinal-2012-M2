package upc.poo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import upc.poo._APPInterfaces.IGrupoDeEstudio;

/**
 *
 * @author americo
 */
class GrupoDeEstudio implements Comparator, IGrupoDeEstudio {
    private String nombre;
    private String decripcion;
    private String academia;
    private String curso;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;  //curso, cancelado, finalizado
    private String instructures;
    private String syllabus;
    private String local;
    private String aula;
    private String mapsLatitud;
    private String mapsLongitud;
    
    private ArrayList<Alumno> alumnosInscritos;

    public GrupoDeEstudio() {
        //Relación de asociación con Alumno para tener lista de Alumno's que están inscritios en el GrupoDeEstudio
        this.alumnosInscritos = new ArrayList<Alumno>();
    }

    //Construtor Completo para dar de alta
    public GrupoDeEstudio(String nombre, String decripcion, String academia, String curso, String fechaInicio, String fechaFin, String estado, String instructures, String syllabus, String local, String aula, String mapsLatitud, String mapsLongitud) {
        //Relación de asociación con Alumno para tener lista de Alumno's que están inscritios en el GrupoDeEstudio
        this.alumnosInscritos = new ArrayList<Alumno>();

        this.nombre = nombre;
        this.decripcion = decripcion;
        this.academia = academia;
        this.curso = curso;
        this.estado = estado;
        this.instructures = instructures;
        this.syllabus = syllabus;
        this.local = local;
        this.aula = aula;
        this.mapsLatitud = mapsLatitud;
        this.mapsLongitud = mapsLongitud;
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.fechaInicio = formatoDelTexto.parse(fechaInicio);
            this.fechaFin = formatoDelTexto.parse(fechaFin);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    /*
    //Constructor para búsquedas
    public GrupoDeEstudio(String nombre, String academia, String curso, String fechaInicio, String fechaFin, String estado) {
        this.nombre = nombre;
        this.academia = academia;
        this.curso = curso;
        this.estado = estado;
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.fechaInicio = formatoDelTexto.parse(fechaInicio);
            this.fechaFin = formatoDelTexto.parse(fechaFin);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    //Constructor Mínimo para dar de alta
    public GrupoDeEstudio(String nombre, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.fechaInicio = formatoDelTexto.parse(fechaInicio);
            this.fechaFin = formatoDelTexto.parse(fechaFin);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    */
    
    //Inscribir a alumno al grupo de estudios
    public void inscribirAlumno(Alumno alumno) {
        this.alumnosInscritos.add(alumno);
    }
    
    public String getAcademia() {
        return academia;
    }

    public String getAula() {
        return aula;
    }

    public String getCurso() {
        return curso;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public String getInstructures() {
        return instructures;
    }

    public String getLocal() {
        return local;
    }

    public String getMapsLatitud() {
        return mapsLatitud;
    }

    public String getMapsLongitud() {
        return mapsLongitud;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSyllabus() {
        return syllabus;
    }

    
    public void setMapsLatitud(String mapsLatitud) {
        this.mapsLatitud = mapsLatitud;
    }

    public void setMapsLongitud(String mapsLongitud) {
        this.mapsLongitud = mapsLongitud;
    }
    

    
    //Define el orden natural
    public int compare(Object o1, Object o2) {
        IGrupoDeEstudio grupo1 = (GrupoDeEstudio) o1;
        IGrupoDeEstudio grupo2 = (GrupoDeEstudio) o2;
        
        return grupo1.getFechaInicio().compareTo(grupo2.getFechaInicio());
    }
}
