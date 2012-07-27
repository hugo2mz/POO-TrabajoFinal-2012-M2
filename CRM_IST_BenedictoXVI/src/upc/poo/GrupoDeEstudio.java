package upc.poo;

import java.util.Date;

class GrupoDeEstudio {
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

    public GrupoDeEstudio() {
    }

    //Constructor para búsquedas
    public GrupoDeEstudio(String nombre, String academia, String curso, Date fechaInicio, Date fechaFin, String estado) {
        this.nombre = nombre;
        this.academia = academia;
        this.curso = curso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    //Constructor Mínimo para dar de alta
    public GrupoDeEstudio(String nombre, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    //Construtor Completo para dar de alta
    public GrupoDeEstudio(String nombre, String decripcion, String academia, String curso, Date fechaInicio, Date fechaFin, String estado, String instructures, String syllabus, String local, String aula, String mapsLatitud, String mapsLongitud) {
        this.nombre = nombre;
        this.decripcion = decripcion;
        this.academia = academia;
        this.curso = curso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.instructures = instructures;
        this.syllabus = syllabus;
        this.local = local;
        this.aula = aula;
        this.mapsLatitud = mapsLatitud;
        this.mapsLongitud = mapsLongitud;
    }
    

    
    
    
    
    
}
