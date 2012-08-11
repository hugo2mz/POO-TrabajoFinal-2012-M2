package upc.poo.view;

import upc.poo._APPInterfaces.IAlumno;
import upc.poo._APPInterfaces.IAlumnoVIEW;
import upc.poo._DB.DBAlumno;
import upc.poo.controller.AlumnoCTRL;
import upc.poo.model.Alumno;

public class CRM {

    public static void main(String[] args) {
        DBAlumno.inicializarDBAlumnos();
        
        IAlumno modeloAlumno = new Alumno();
        IAlumnoVIEW vistaAlumno = new AlumnoVIEW();
        AlumnoCTRL controlAlumno = new AlumnoCTRL(vistaAlumno, modeloAlumno);
        
        vistaAlumno.setControlador(controlAlumno);
        vistaAlumno.arranca();
    }
}
