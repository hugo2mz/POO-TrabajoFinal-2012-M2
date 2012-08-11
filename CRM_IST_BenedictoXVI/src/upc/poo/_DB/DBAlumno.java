package upc.poo._DB;

import java.util.ArrayList;
import upc.poo.model.Alumno;

public class DBAlumno {
    public static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    
    public static ArrayList conectarDBAlumnos() {
        return alumnos;
    }
    
    public static void inicializarDBAlumnos() {
    //public static ArrayList simulateDBCientes() {
        //ArrayList<Cliente> alumnos = new ArrayList<Cliente>();
        
        Alumno alumno1 = new Alumno("12345678", "Mario", "Martinez", "Garay", "jmartinez@movistar.pe", "520-5432", "987123456", "P", "17-05-2009", "");
        Alumno alumno2 = new Alumno("12345679", "José", "Rodríguez", "Poma", "jpma@tt.pe", "528-5431", "987123411", "P", "27-09-2008", "");
        Alumno alumno3 = new Alumno("12345670", "Andrés", "Ramos", "Huaita", "hramos@todsa.pe", "613-5439", "987123422", "P", "19-02-2010", "");
        Alumno alumno4 = new Alumno("12345611", "Enrique", "Salas", "Taipe", "esalas@jalo.com.pe", "719-5430", "987123433", "P", "01-10-2011", "");
        Alumno alumno5 = new Alumno("12345622", "Manuel", "Montoya", "Santos", "mmontoya@loisa.com.pe", "640-5431", "987123444", "P", "11-09-2012", "");
        Alumno alumno6 = new Alumno("12345633", "Javier", "Rojas", "Meza", "javier.rojas@comteperu.com", "756-5432", "987123455", "P", "29-04-2011", "");
        Alumno alumno7 = new Alumno("12345644", "Antero", "Melgar", "Chaparro", "amelgar@ddes.com", "799-5433", "987123466", "P", "31-03-2012", "");
        Alumno alumno8 = new Alumno("12345644", "Miguel", "Ramos", "Poma", "mramos@tanta.pe", "612-5535", "987123477", "P", "31-04-2012", "");
        Alumno alumno9 = new Alumno("12345655", "Augusto", "Franco", "Bustamente", "afranco@bara.pe", "455-5434", "987123477", "C", "30-01-2012", "28-04-2012");
        Alumno alumno10 = new Alumno("12345666", "Celika", "Nakamura", "Tak", "cnakamura@bara.pe", "543-5435", "987123488", "C", "21-10-2011", "15-07-2012");
        Alumno alumno11 = new Alumno("12345677", "Carla", "Wan", "Tang", "carla.wan@bbv.pe", "511-5436", "987123499", "C", "29-05-2011", "01-07-2012");
        Alumno alumno12 = new Alumno("12345688", "Javier", "Huamaní", "Lee", "javier.huamani@salud.pe", "599-5437", "987123000", "C", "01-06-2011", "09-05-2012");
        
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);
        alumnos.add(alumno5);
        alumnos.add(alumno6);
        alumnos.add(alumno7);
        alumnos.add(alumno8);
        alumnos.add(alumno9);
        alumnos.add(alumno10);
        alumnos.add(alumno11);
        alumnos.add(alumno12);
        
        //return clientes;
    }
}
