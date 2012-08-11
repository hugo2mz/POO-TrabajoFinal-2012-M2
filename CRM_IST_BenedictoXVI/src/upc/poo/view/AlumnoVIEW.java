package upc.poo.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import upc.poo._APPInterfaces.IAlumno;
import upc.poo._APPInterfaces.IAlumnoVIEW;
import upc.poo.controller.AlumnoCTRL;

public class AlumnoVIEW implements IAlumnoVIEW {
    private AlumnoCTRL controlAlumno;
    //private String valorOculto;
    private ArrayList<String> valorOculto = new ArrayList<>();
    // Gestión de la entrada por teclado
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    //Métodos de la interfaz de la Vista:
    public void setControlador(AlumnoCTRL c) {
        controlAlumno = c;
    }

    public void arranca() {
        procesaNuevaOperacion();
    }

    public void escribeCambio(String s) {
        //Escribe el resultado:
        System.out.println("\n" + s + "\n");
        // y vuelve a solicitar al usuario una operación:
        procesaNuevaOperacion();
    }
    
    public void escribeCambio(ArrayList<IAlumno> lista) {
        //Escribe el resultado:
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (IAlumno objAlumno : lista) {
            valorOculto.add(0, objAlumno.getDni()); //Guardará el DNI del último Cliente o Prospecto
            valorOculto.add(1, objAlumno.getFlagTipoAlumno()); //Guardará el Flag del último Cliente o Prospecto
            
            if (objAlumno.getFlagTipoAlumno().equals("C")) {   //Si es que es del tipo CLIENTE
                System.out.println(
                        objAlumno.getDni() + "\t" +
                        objAlumno.getNombres() + "\t" +
                        objAlumno.getaPaterno() + "\t" +
                        objAlumno.getaMaterno() + "\t" +
                        objAlumno.getEmail() + "\t" +
                        objAlumno.getTelefono() + "\t" +
                        objAlumno.getCelular() + "\t" +
                        
                        objAlumno.getFechaCliente("dd-MM-yyyy")
                    );
            }
            if (objAlumno.getFlagTipoAlumno().equals("P")) {   //Si es que es del tipo PROSPECTO
                System.out.println(
                        objAlumno.getDni() + "\t" +
                        objAlumno.getNombres() + "\t" +
                        objAlumno.getaPaterno() + "\t" +
                        objAlumno.getaMaterno() + "\t" +
                        objAlumno.getEmail() + "\t" +
                        objAlumno.getTelefono() + "\t" +
                        objAlumno.getCelular() + "\t" +

                        objAlumno.getFechaContacto("dd-MM-yyyy")
                    );
            }
        }//for
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        
        System.out.print("\n");
        
        if (lista.size() == 1) {
            procesaEditarRegistro();
        } else 
        if (lista.isEmpty()) {
            escribeCambio("No se encontraron registros para los filtros ingresados.");
            //procesaNuevaOperacion();    // y vuelve a solicitar al usuario una operación
        } else {
            procesaNuevaOperacion();    // y vuelve a solicitar al usuario una operación
        }
        
        /*
        if(modo == BUSCARPROSPECTO) {
            
        }
        if(modo == VERLISTASOLOPROSPECTOS) {
            
        }
        * */
    }
    
    /*
    private void menuBusquedaCliente() {
        System.out.println("CRM >> Buscar Clientes:\n");
        System.out.println("1: DNI");
        System.out.println("2: Listar todos los clientes");
        System.out.println("0: salir\n");
        System.out.print("Elige una opción>> ");
    }

    private void procesaBusquedaCliente() {
        int operacion;

        menuBusquedaCliente();
        operacion = leerOpcion();        
    }
    * 
    */
    
    // Método para mostrar al usuario las opciones que tiene
    private void menuPrincipalAlumno() {
        System.out.println("CRM >> Alumnos:\n================");
        System.out.println("1: Buscar Prospectos");
        System.out.println("2: Listar todos los Prospectos");
        System.out.println("3: Nuevo Prospecto");
        System.out.println("=================================");
        System.out.println("4: Buscar Clientes");
        System.out.println("5: Listar todos los Clientes");
        System.out.println("6: Nuevo Cliente");
        System.out.println("=================================");
        System.out.println("0: salir\n");
        System.out.print("Elige una opción>> ");
    }
    
    public void menuEditarRegistro() {
        System.out.println("CRM >> Alumnos | Opciones:\n==============================");
        System.out.println("1: Editar");
        System.out.println("2: Convertir");
        System.out.println("3: Eliminar");
        System.out.println("0: Atrás");
        System.out.print("Elige una opción>> ");
    }

    public void procesaEditarRegistro() {
        int operacion;

        menuEditarRegistro();
        operacion = leerOpcion();

        if (operacion == 0 ) {
            procesaNuevaOperacion();    //ir atrás
        } else
        if (operacion == 1 ) {
            controlAlumno.ejecutor(EDITARREGISTRO);
        } else
        if (operacion == 2 ) {
            controlAlumno.ejecutor(CONVERTIRREGISTRO);
        } else
        if (operacion == 3 ) {
            controlAlumno.ejecutor(ELIMINARREGISTRO);
        } else {
            operacionIncorrecta();
        }
    }
    
    public void procesaNuevaOperacion() {
        int operacion;

        menuPrincipalAlumno();
        operacion = leerOpcion();

        if (operacion == 0 ) {
            System.out.println("\nFin de programa\n");
            System.exit(0);
        } else
        if (operacion == 1 ) {              //ctrl.actionPerformed( new ActionEvent(this, nroOperacion, CONSTANTE) );
            controlAlumno.ejecutor(BUSCARPROSPECTO);
        } else
        if (operacion == 2 ) {
            controlAlumno.ejecutor(VERLISTASOLOPROSPECTOS);
        } else
        if (operacion == 3 ) {
            controlAlumno.ejecutor(NUEVOPROSPECTO);
        } else
        if (operacion == 4 ) {
            controlAlumno.ejecutor(BUSCARCLIENTES);
        } else
        if (operacion == 5 ) {
            controlAlumno.ejecutor(VERLISTASOLOCLIENTES);
        } else
        if (operacion == 6 ) {
            controlAlumno.ejecutor(NUEVOCLIENTE);
        } else {
            operacionIncorrecta();
        }
    }
        
    private int leerOpcion() {
        String s = null;
        try { s = in.readLine();
            return Integer.parseInt(s);
        } catch(Exception e){
            operacionIncorrecta(); return 0;
        }
    }
    
    private void operacionIncorrecta() {
        System.out.print("\nError: Operación incorrecta!!\n ");
        procesaNuevaOperacion();
    }
    
    private String leerValor() {
        String s = null;
        try {
            s = in.readLine();
            //Double.parseDouble(s);
            return s;
        }
        catch(Exception e){
            System.out.println("\nError: Ingrese una cadena válida:\n ");
            return leerValor();
        }
    }

    public String getTextBox(String mensajeAmostrar) {
        System.out.print(mensajeAmostrar + ">> ");
        return leerValor();
    }
    
    public String getTextBoxF(String mensajeAmostrar) { //Textbox Obligatorio
        System.out.print(mensajeAmostrar + " (*)>> ");
        String rpta = leerValor();
        if (rpta.trim().isEmpty()) {
            rpta = getTextBoxF(mensajeAmostrar);
        }
        return rpta;
    }
    
    public String getDialogYesNo(String mensajeAmostrar) { //Textbox Obligatorio
        System.out.print(mensajeAmostrar + " [Escriba SI o NO]>> ");
        String rpta = leerValor();
        if (rpta.trim().isEmpty() || !rpta.equals("SI") && !rpta.equals("NO")) {
            rpta = getDialogYesNo(mensajeAmostrar);
        }
        return rpta;
    }

    public String getTextBoxHidden(int i) {
        return valorOculto.get(i);
    }

}
